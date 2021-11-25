import java.util.ArrayList;
import java.util.List;

/**
 * IMPORTANT: This class is incomplete. Please look for "TODO" comments.
 *
 * Question:
 * Write a parse to recognize the language specified by the following grammar:
 * S := () ; S := )S( ; S := SS ;
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

        // TODO: Complete this method S := () ; S := )S( ; S := SS ;
		// START YOUR CODE
		List<Token.Type> typeList = new ArrayList<>();
		while (true){
			Token t = _tokeniser.takeNext();
			if (t == null){
				if (!_tokeniser.isNextValid()) {
					return false;
				} else {
					break;
				}
			} else {
				typeList.add(t.type);
			}
		}
		// END YOUR CODE
		return isValid(typeList);
    }

    public boolean isValid(List<Token.Type> typeList){
		if (typeList.get(0) == Token.Type.LEFT_BRACKET){
			if (typeList.size() < 2) return false;
			if (typeList.get(1) == Token.Type.RIGHT_BRACKET){
				if (typeList.size() == 2) return true;
				return isValid(typeList.subList(2, typeList.size()));
			}
		} else if (typeList.get(0) == Token.Type.RIGHT_BRACKET){
			if (typeList.size() < 4){
				return false;
			}
			for (int i = typeList.size() - 1; i >= 3; i --){
				if (typeList.get(i) == Token.Type.LEFT_BRACKET){
					if (i == typeList.size() - 1){
						if (isValid(typeList.subList(1,i))) return true;
					} else {
						if (isValid(typeList.subList(1,i)) && isValid(typeList.subList(i+1,typeList.size()))){
							return true;
						}
					}
				}
			}
			return false;
		}
		return false;
	}

}
