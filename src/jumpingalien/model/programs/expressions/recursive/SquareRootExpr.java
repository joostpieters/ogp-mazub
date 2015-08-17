package jumpingalien.model.programs.expressions.recursive;

import jumpingalien.model.programs.Environment;
import jumpingalien.model.programs.Expression;
import jumpingalien.part3.programs.SourceLocation;

/**
 * Created by covert on 14/08/15.
 */
public class SquareRootExpr extends RecursiveExpression{
    public SquareRootExpr(SourceLocation source, Expression<Double> expression) {
        super(source, expression);
    }

    public Double getValue(Environment en) {
        return Math.sqrt((double) getInternalExpression().getValue(en));
    }
}
