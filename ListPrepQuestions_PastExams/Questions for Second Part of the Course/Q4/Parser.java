/**
 * IMPORTANT: This class is incomplete. Please look for "TODO" comments.
 *
 * Question:
 * Write a parse to recognize the language specified by the following grammar:
 * X := + | - | * | / ; Y := 1 | 2 | 3 | 5 | 6 | 7 | 8 | 9 | 0 ; S := YXS | Y ;
 *
 * @author huy.pham
 */
public class Parser {
    Tokeniser _tokeniser;
    
    public Parser(Tokeniser tokeniser) {
		_tokeniser = tokeniser;
    }

	/**
	 * @return True if the given tokens conform with the grammar. False, otherwise.
	 */
	public boolean parseExp() {
		if (!_tokeniser.isNextValid()) return false;
		if (!_tokeniser.hasNext()) {
			return true;
		}

        // TODO: Complete this method
		// START YOUR CODE
		if (_tokeniser.takeNext().type == Token.Type.NUMBER){
			if (!_tokeniser.isNextValid()) return false;
			if (!_tokeniser.hasNext()) return true;
			if (_tokeniser.next().type == Token.Type.MATH_OPERATION){
				_tokeniser.takeNext();
				if (!_tokeniser.hasNext()) return false;
				return parseExp();
			}
		}


		// END YOUR CODE
		return false;
    }

}
