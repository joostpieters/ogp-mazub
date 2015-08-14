package jumpingalien.model.programs.expressions.compare;

import jumpingalien.model.programs.Expression;
import jumpingalien.model.programs.expressions.data.BoolExpr;
import jumpingalien.model.programs.expressions.data.DataExpression;

/**
 * Created by covert on 14/08/15.
 */
public class AndExpr extends CompareExpression {
    public AndExpr(Expression<Boolean> expr1, Expression<Boolean> expr2) {
        super(expr1, expr2);
    }

    @Override
    public boolean compare(boolean bool1, boolean bool2) {
        return bool1 && bool2;
    }

}
