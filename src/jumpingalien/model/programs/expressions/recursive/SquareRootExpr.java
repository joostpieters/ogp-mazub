package jumpingalien.model.programs.expressions.recursive;

import jumpingalien.model.programs.Expression;
import jumpingalien.model.programs.expressions.data.DoubleConstExpr;
import jumpingalien.part3.programs.SourceLocation;

/**
 * Created by covert on 14/08/15.
 */
public class SquareRootExpr extends RecursiveExpression{
    public SquareRootExpr(SourceLocation source, Expression<Double> expression) {
        super(source, expression);
    }

    @Override
    public DoubleConstExpr getValue() {
        return new DoubleConstExpr(getSourceLocation(),Math.sqrt((double) getInternalExpression().getValue()));
    }
}
