import java.net.Proxy;

/**
 * IMPORTANT: This class is incomplete. Please look for "TODO" comments.
 * 
 * Implement next() method in Tokeniser.java to extract the SQL commands as Tokens as follows:
 * 
 * Token 1:
 * originalTokenStr: INSERT INTO table_name (column1, column2, column3, ...)
 * type: INSERT_INTO
 * value: table_name (column1, column2, column3, ...)
 * 
 * Token 2:
 * originalTokenStr: VALUES (value1, value2, value3, ...)
 * type: VALUES
 * value: (value1, value2, value3, ...)
 * 
 * Some brackets in the SQL commands may be missing. Please return null if some brackets are missing
 *
 * Please see test cases in TokeniserTest.java.
 */
public class Tokeniser {
	private String _buffer;

	public Tokeniser(String buffer) {
		this._buffer = buffer;
		int idx = this._buffer.indexOf(";");
		if (idx > 0) {
			this._buffer = this._buffer.substring(0, idx);
		}
	}

	/**
	 * Return the next token without changing the buffer
	 * 
	 * @return the next token OR null when there is no more token or the next token
	 *         is invalid.
	 */
	public Token next() {
		if (_buffer.isEmpty())
			return null;

		// TODO: Complete this method
		// START YOUR CODE
		int pInsert = _buffer.indexOf("INSERT INTO");
		int pValue = _buffer.indexOf("VALUES");
		int pBracketL;
		int pBracketR;
		Token currentToken;

		if (pInsert < 0 && pValue < 0){
			return null;
		} else if (pInsert < 0 && pValue >= 0){
			pBracketL = _buffer.substring(pValue).indexOf("(");
			pBracketR = _buffer.substring(pValue).indexOf(")");
			if (pBracketL < 0 || pBracketR < 0 || pBracketL > pBracketR) return null;
			currentToken = new Token(Token.Type.VALUES, _buffer.substring(pValue+7, pBracketR + pValue + 1), _buffer.substring(pValue, pBracketR + pValue + 1));
		} else if (pInsert >= 0 && pValue < 0) {
			pBracketL = _buffer.substring(pInsert).indexOf("(");
			pBracketR = _buffer.substring(pInsert).indexOf(")");
			if (pBracketL < 0 || pBracketR < 0 || pBracketL > pBracketR) return null;
			currentToken = new Token(Token.Type.INSERT_INTO, _buffer.substring(pInsert+12, pBracketR + pInsert + 1), _buffer.substring(pInsert, pBracketR + pInsert + 1));
		} else {
			if (pInsert < pValue){
				pBracketL = _buffer.substring(pInsert).indexOf("(");
				pBracketR = _buffer.substring(pInsert).indexOf(")");
				if (pBracketL < 0 || pBracketR < 0 || pBracketL > pBracketR || pBracketL > pValue) return null;
				currentToken = new Token(Token.Type.INSERT_INTO, _buffer.substring(pInsert+12, pBracketR + pInsert + 1), _buffer.substring(pInsert, pBracketR + pInsert + 1));
			} else {
				pBracketL = _buffer.substring(pValue).indexOf("(");
				pBracketR = _buffer.substring(pValue).indexOf(")");
				if (pBracketL < 0 || pBracketR < 0 || pBracketL > pBracketR || pBracketL > pInsert) return null;
				currentToken = new Token(Token.Type.VALUES, _buffer.substring(pValue+7, pBracketR + pValue + 1), _buffer.substring(pValue, pBracketR + pValue + 1));
			}
		}
		// You are allowed to remove the following 'return null' if necessary
		return currentToken;
		
		// END YOUR CODE
	}

	/**
	 * Return the next token and remove it from the buffer
	 * 
	 * @return the next token OR null when there is no more token or the next token
	 *         is invalid.
	 */
	public Token takeNext() {
		Token nextToken = next();
		if (nextToken == null)
			return null;

		if (nextToken.originalTokenStr.length() < _buffer.length()) {
			_buffer = _buffer.substring(nextToken.originalTokenStr.length()).trim();
		} else {
			_buffer = "";
		}

		return nextToken;
	}

	/**
	 * @return whether there is another token to parse in the buffer
	 */
	public boolean hasNext() {
		return next() != null;
	}
}