import java.util.Locale;

public class MyTokenizer implements Tokenizer {

    private String buffer;		//save text
    private Token currentToken;	//save token extracted from next()

    /**
     *  Tokenizer class constructor
     *  The constructor extracts the first token and save it to currentToken
     *  **** please do not modify this part ****
     */
    public MyTokenizer(String text) {
    	buffer = text;		// save input text (string)
    	next();		// extracts the first token.
    }

    /**
     *  This function will find and extract a next token from {@code buffer} and
     *  save the token to {@code currentToken}.
     */
    public void next() {


        //buffer = buffer.trim(); // remove whitespace

        if(buffer.trim().isEmpty()) {
            currentToken = null;	// if there's no string left, set currentToken null and return
            return;
        }

        // ########## YOUR CODE STARTS HERE ##########
        int pos = 0;
        char firstChar;
        while ((firstChar = buffer.charAt(pos)) == ' '){
            pos++;
        }
        int posStart = pos;

        if (Character.isDigit(firstChar)){
            while (pos < buffer.length() && Character.isDigit(buffer.charAt(pos))){
                pos++;
            }
            currentToken = new Token(buffer.substring(posStart,pos), Token.Type.INTEGER_NUMBER);
        } else if (Character.isAlphabetic(firstChar)){
            while (pos < buffer.length() && Character.isAlphabetic(buffer.charAt(pos))){
                pos++;
            }
            String s = buffer.substring(posStart,pos);
            if (s.equals(s.toLowerCase())){
                currentToken = new Token(s, Token.Type.LOWER_CASE_WORD);
            } else if (s.equals(s.toUpperCase())) {
                currentToken = new Token(s, Token.Type.UPPER_CASE_WORD);
            } else {
                if (s.length() <= 3){
                    currentToken = new Token(s, Token.Type.SHORT_CAMEL_CASE_WORD);
                } else {
                    currentToken = new Token(s, Token.Type.LONG_CAMEL_CASE_WORD);
                }
            }
        } else {
            pos++;
            currentToken = new Token(firstChar+"", Token.Type.NON_ALPHANUMERIC);
        }
        // ########## YOUR CODE ENDS HERE ##########
        
        // Remove the extracted token from buffer
        //int tokenLen = currentToken.getValue().length();
        buffer = buffer.substring(pos);
    }

    /**
     *  returned the current token extracted by {@code next()}
     *  **** please do not modify this part ****
     *  
     * @return type: Token
     */
    public Token current() {
    	return currentToken;
    }

    /**
     *  check whether there still exists another tokens in the buffer or not
     *  **** please do not modify this part ****
     *  
     * @return type: boolean
     */
    public boolean hasNext() {
    	return currentToken != null;
    }


}