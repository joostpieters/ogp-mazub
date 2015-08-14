package jumpingalien.model.programs.expressions.operator;

import jumpingalien.model.programs.Expression;
import jumpingalien.model.programs.expressions.data.DataExpression;
import jumpingalien.model.programs.expressions.data.DoubleConstExpr;
import jumpingalien.part3.programs.SourceLocation;

/**
 * Created by covert on 14/08/15.
 */
public class DivisonExpr extends OperatorExpression {
    public DivisonExpr(Expression expr1, Expression expr2) {
        super(expr1, expr2);
    }

    @Override
    public DoubleConstExpr getValue() {
        return new DoubleConstExpr(((double)getExprOne().getValue() / (double) getExprTwo().getValue()));
    }
}
