package jumpingalien.model.programs.expressions.logical;

import jumpingalien.model.programs.Expression;
import jumpingalien.part3.programs.SourceLocation;

/**
 * Created by covert on 14/08/15.
 */
public class OrExpr extends LogicalExpression {
    public OrExpr(SourceLocation source, Expression<Boolean> expr1, Expression<Boolean> expr2) {
        super(source, expr1, expr2);
    }

    @Override
    public Boolean exec(boolean bool1, boolean bool2) {
        return bool1 || bool2;
    }
}
