package jumpingalien.model.programs.statements.primitive;

import jumpingalien.model.programs.Environment;
import jumpingalien.model.programs.Expression;
import jumpingalien.model.programs.Statement;
import jumpingalien.part3.programs.SourceLocation;

/**
 * Created by covert on 16/08/15.
 */
public abstract class PrimitiveStatement<dataType> extends Statement {
    Expression<dataType> expression;
    public PrimitiveStatement(SourceLocation sourceLocation, Expression<dataType> exp) {
        super(sourceLocation);
    }

    public PrimitiveStatement(SourceLocation sourceLocation) {
        super(sourceLocation);
    }

    protected abstract void doAction(Environment env, Expression<dataType> expression);
    public void exe(Environment env){

            doAction(env,expression);

    }
}
