package jumpingalien.model.programs;

import jumpingalien.part3.programs.SourceLocation;
import jumpingalien.part3.programs.internal.generated.JumpingAlienProgParser;

import java.util.LinkedList;

/**
 * Created by covert on 14/08/15.
 */
public class Statement {
    private SourceLocation source;
    private LinkedList<Statement> allStatements;

    public Statement(SourceLocation sourceLocation,LinkedList<Statement> statements) {
        source = sourceLocation;allStatements = statements;
    }

    public void execute(JumpingAlienProgParser.ProgramContext context){

    }


    public void execute(JumpingAlienProgParser.ProgramContext context) { //NOTE: This isn't used, as ProgramContext handles StatementBlocks separately.
        for (Statement statement : statements) {
            statement.execute(context);
        }
    }

    public List<Statement> getStatements() {
        return statements;
    }
}
