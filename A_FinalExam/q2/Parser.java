import java.util.LinkedList;
import java.util.List;

public class Parser {

	private final Tokeniser tokeniser;

	public Parser(Tokeniser tokeniser) {
		this.tokeniser = tokeniser;
	}

	public List<Command> parseCmds() {

		List<Command> commands = new LinkedList<>();

		// TODO
		// ########## YOUR CODE STARTS HERE ##########
		while (tokeniser.hasNext()){
			if (tokeniser.current().getType() == Token.Type.RETRIEVE){
				//if (!tokeniser.hasNext()) return commands;
				tokeniser.next();
				//if (tokeniser.current().getType() != Token.Type.PARAMETER) return commands;
				String para1 = tokeniser.current().getValue();
				//if (!tokeniser.hasNext()) return commands;
				tokeniser.next();
				//if (tokeniser.current().getType() != Token.Type.FROM) return commands;
				//if (!tokeniser.hasNext()) return commands;
				tokeniser.next();
				//if (tokeniser.current().getType() != Token.Type.PARAMETER) return commands;
				String para2 = tokeniser.current().getValue();
				//if (!tokeniser.hasNext()) return commands;
				tokeniser.next();
				//if (tokeniser.current().getType() != Token.Type.TERMINATOR) return commands;
				commands.add(new RetrieveCommand(para1, para2));
				tokeniser.next();
			} else if (tokeniser.current().getType() == Token.Type.STORE){
				//if (!tokeniser.hasNext()) return commands;
				tokeniser.next();
				//if (tokeniser.current().getType() != Token.Type.PARAMETER) return commands;
				String para1 = tokeniser.current().getValue();
				//if (!tokeniser.hasNext()) return commands;
				tokeniser.next();
				//if (tokeniser.current().getType() != Token.Type.TO) return commands;
				//if (!tokeniser.hasNext()) return commands;
				tokeniser.next();
				//if (tokeniser.current().getType() != Token.Type.PARAMETER) return commands;
				String para2 = tokeniser.current().getValue();
				//if (!tokeniser.hasNext()) return commands;
				tokeniser.next();
				//if (tokeniser.current().getType() != Token.Type.TERMINATOR) return commands;
				commands.add(new StoreCommand(para1, para2));
				tokeniser.next();
			} else {
				return commands;
			}
		}
		// ########## YOUR CODE ENDS HERE ##########

		return commands;
	}
}
