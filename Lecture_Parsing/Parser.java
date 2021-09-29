
/**
 * Parser for grammar:
 * 
 * <exp> ::= <term> | <term> + <exp>
 * <term> ::= <factor> | <factor> * <term>
 * <factor> ::= <lit>
 *  
 * 
 *
 */
public class Parser {
	
	/**
	 * Parser for <exp>.
	 * <exp> has two production rules: <term> | <term> + <exp>
	 * If there's + token after parsing term, the parser return an addition expression
	 * otherwise it returns parsed term.
	 * 
	 * @param tok Tokenizer
	 * @return parsed expression for <exp>
	 */
	public static Exp parseExp(Tokenizer tok) {
		System.out.println("\nCall parseExp(), current() = "+tok.current().toString());
		System.out.println("  parseExp-- Exp term = parseTerm(tok);");
		Exp term = parseTerm(tok);
		System.out.println("  parseExp-- term = "+term.show());
		if(tok.hasNext() && tok.current().equals("+")) {
			System.out.println("  parseExp-- tok.hasNext() && tok.current().equals(+)");
			tok.next();
			System.out.println("  parseExp-- tok.next();  current() = "+tok.current().toString());
			System.out.println("  parseExp-- Exp exp = parseExp(tok);");
			Exp exp = parseExp(tok);
			System.out.println("  parseExp-- exp = "+exp.show());
			System.out.println("  parseExp-- RETURN AppExp("+term.show()+", "+exp.show()+")");
			return new AddExp(term, exp);
		}else {
			System.out.println("  parseExp-- RETURN term = "+term.show());
			return term;
		}
	}
	
	/**
	 * Parser for <term>.
	 * <term> has two production rules: <factor> | <factor> * <term>
	 * If there's * token after parsing factor, the parser return a multiplication expression
	 * otherwise it returns parsed factor.
	 * 
	 * @param tok Tokenizer
	 * @return parsed expression for <term>
	 */
	public static Exp parseTerm(Tokenizer tok) {
		System.out.println("\nCall parseTerm(), current() = "+tok.current().toString());
		System.out.println("  parseTerm-- Exp factor = parseFactor(tok);");
		Exp factor = parseFactor(tok);
		System.out.println("  parseTerm-- factor = "+factor.show());
		
		if (tok.hasNext() && tok.current().equals("*")) {
			System.out.println("  parseTerm-- tok.hasNext() && tok.current().equals(*)");
			tok.next();
			System.out.println("  parseTerm-- tok.next();  current() = "+tok.current().toString());
			System.out.println("  parseTerm-- Exp term = parseTerm(tok);");
			Exp term = parseTerm(tok);
			System.out.println("  parseTerm-- term = "+term.show());
			System.out.println("  parseTerm-- RETURN MultExp("+factor.show()+", "+term.show()+")");
			return new MultExp(factor, term);
		}else {
			System.out.println("  parseTerm-- RETURN factor = "+factor.show());
			return factor;
		}
	}

	/**
	 * Parser for <factor>
	 * Note that <factor> has a single production rule.
	 * It always return integer literal as a parsed result.
	 * 
	 * @param tok Tokenizer
	 * @return parsed expression for <factor>
	 */
	private static Exp parseFactor(Tokenizer tok) {
		System.out.println("\nCall parseFactor(), current() = "+tok.current().toString());
		Exp lit = new LitExp((Integer)tok.current());
		System.out.println("  parseFactor-- Exp lit = new LitExp((Integer)tok.current());");
		tok.next();
		if (tok.current()!= null){
			System.out.println("  parseFactor-- tok.next();  current() = "+tok.current().toString());
		}

		System.out.println("  parseFactor-- RETURN lit = "+lit.show());
		return lit;		
	}

}
