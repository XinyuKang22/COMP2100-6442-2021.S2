import java.util.HashMap;
import java.util.Map;

public class Tokeniser {

	private String buffer; // save text
	private Token currentToken; // save token extracted from next()

	public Tokeniser(String text) {
		buffer = text; // save input text (string)
		next(); // extracts the first token.
	}

	/**
	 * This function will find and extract a next token from {@code buffer} and save
	 * the token to {@code currentToken}.
	 */
	public void next() {

		buffer = buffer.trim(); // remove whitespace
		if (buffer.isEmpty()) {
			currentToken = null; // if there's no string left, set currentToken null and return
			return;
		}

		// TODO	RETRIEVE, FROM, STORE, TO, TERMINATOR, PARAMETER;
		// ########## YOUR CODE STARTS HERE ##########
		String bufferCopy = buffer.toUpperCase();
		if (bufferCopy.indexOf("RETRIEVE") == 0){
			currentToken = new Token(Token.Type.RETRIEVE, buffer.substring(0,8));
		} else if (bufferCopy.indexOf("FROM") == 0){
			currentToken = new Token(Token.Type.FROM, buffer.substring(0,4));
		} else if (bufferCopy.indexOf("STORE") == 0){
			currentToken = new Token(Token.Type.STORE, buffer.substring(0,5));
		} else if (bufferCopy.indexOf("TO") == 0){
			currentToken = new Token(Token.Type.TO, buffer.substring(0,2));
		} else if (bufferCopy.indexOf(";") == 0){
			currentToken = new Token(Token.Type.TERMINATOR, buffer.substring(0,1));
		} else {
			Map<Token.Type, Integer> locMap = new HashMap<>();
			int pRe = bufferCopy.indexOf("RETRIEVE");
			locMap.put(Token.Type.RETRIEVE, pRe);
			int pFr = bufferCopy.indexOf("FROM");
			locMap.put(Token.Type.FROM, pFr);
			int pSt = bufferCopy.indexOf("STORE");
			locMap.put(Token.Type.STORE, pSt);
			int pTo = bufferCopy.indexOf("TO");
			locMap.put(Token.Type.TO, pTo);
			int pTe = bufferCopy.indexOf(";");
			locMap.put(Token.Type.TERMINATOR, pTe);
			int minLoc = bufferCopy.length();
			for (Map.Entry<Token.Type, Integer> entry:locMap.entrySet()){
				if (entry.getValue() >= 0){
					if (entry.getValue() < minLoc){
						minLoc = entry.getValue();
					}
				}
			}
			if (minLoc < bufferCopy.length()){
				currentToken = new Token(Token.Type.PARAMETER, buffer.substring(0,minLoc).trim());
			} else {
				currentToken = new Token(Token.Type.PARAMETER, buffer.trim());
			}
		}
		// ########## YOUR CODE ENDS HERE ##########

		// Remove the extracted token from buffer
		int tokenLen = currentToken.getValue().length();
		buffer = buffer.substring(tokenLen);
	}

	/**
	 * returned the current token extracted by {@code next()} **** please do not
	 * modify this part ****
	 * 
	 * @return type: Token
	 */
	public Token current() {
		return currentToken;
	}

	/**
	 * check whether there still exists another tokens in the buffer or not ****
	 * please do not modify this part ****
	 * 
	 * @return type: boolean
	 */
	public boolean hasNext() {
		return currentToken != null;
	}

}