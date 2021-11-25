import java.util.Set;

/**
 * IMPORTANT: This class is incomplete. Please look for "TODO" comments.
 *
 * @author huy.pham
 */
public class Tokeniser {
    private String _buffer;
    public static final Set<Character> MATH_OPERATIONS = Set.of('+', '-', '*', '/');

    public Tokeniser(String buffer) {
        this._buffer = buffer;
    }

    /**
     * Return the next token without changing the buffer
     * @return the next token OR null when there is no more token or the next token is invalid.
     */
    public Token next() {
        if (_buffer.isEmpty())
            return null;

        // TODO: Complete this method   X := + | - | * | / ; Y := 1 | 2 | 3 | 5 | 6 | 7 | 8 | 9 | 0 ; S := YXS | Y ;
        // hints: you might want to use Character.isDigit(...) to check if a character is digit
        // START YOUR CODE
        char c = _buffer.charAt(0);
        if (MATH_OPERATIONS.contains(c)){
            return new Token(Token.Type.MATH_OPERATION, c+"");
        } else if (Character.isDigit(c)){
            return new Token(Token.Type.NUMBER, c+"");
        }


        // END YOUR CODE

        return null;
    }

    /**
     * Return the next token and remove it from the buffer
     * @return the next token OR null when there is no more token or the next token is invalid.
     */
    public Token takeNext() {
        Token nextToken = next();
        if (nextToken == null)
            return null;

        if (nextToken.originalTokenStr.length() < _buffer.length()) {
            _buffer = _buffer.substring(nextToken.originalTokenStr.length());
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

    /**
     * @return True only if the next token is valid
     */
    public boolean isNextValid() {
        return next() != null || _buffer.isEmpty();
    }
}