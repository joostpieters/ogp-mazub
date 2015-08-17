package jumpingalien.model.programs.statements.primitive;

import jumpingalien.model.programs.Environment;
import jumpingalien.model.programs.Expression;
import jumpingalien.part3.programs.IProgramFactory;
import jumpingalien.part3.programs.SourceLocation;

/**
 * Created by covert on 16/08/15.
 */
public class StopRunExpr extends PrimitiveStatement<IProgramFactory.Direction> {
    public StopRunExpr(SourceLocation sourceLocation, Expression<IProgramFactory.Direction> exp) {
        super(sourceLocation, exp);
    }

    protected void doAction(Environment env, Expression<IProgramFactory.Direction> expression) {
        env.getActiveCaller().endHorMove();
    }
}