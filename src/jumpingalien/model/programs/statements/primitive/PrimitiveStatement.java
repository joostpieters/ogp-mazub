package jumpingalien.model.programs.statements.primitive;

import jumpingalien.model.programs.Environment;
import jumpingalien.model.programs.Expression;
import jumpingalien.model.programs.Statement;
import jumpingalien.part3.programs.SourceLocation;

/**
 * Created by covert on 16/08/15.
 */
public abstract class PrimitiveStatement extends Statement {
    Expression expression;
    public PrimitiveStatement(SourceLocation sourceLocation, Expression exp) {
        super(sourceLocation);
    }

    protected abstract void doAction(Environment env, Expression expression);

    public void exe(Environment env){
        doAction(env,expression);
    }
}
