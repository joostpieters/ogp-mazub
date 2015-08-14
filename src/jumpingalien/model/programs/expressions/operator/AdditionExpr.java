package jumpingalien.model.programs.expressions.operator;

import jumpingalien.model.programs.Expression;
import jumpingalien.model.programs.expressions.data.DataExpression;
import jumpingalien.model.programs.expressions.data.DoubleConstExpr;

/**
 * Created by covert on 14/08/15.
 */
public class AdditionExpr extends OperatorExpression {
    public AdditionExpr(Expression<Double> exprOne, Expression<Double> exprTwo) {
        super(exprOne, exprTwo);
    }

    @Override
    public DataExpression getValue() {
        return new DoubleConstExpr((double) getExprOne().getValue() + ((double) getExprTwo().getValue())) ;
    }
}
