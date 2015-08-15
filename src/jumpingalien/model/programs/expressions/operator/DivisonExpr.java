package jumpingalien.model.programs.expressions.operator;

import jumpingalien.model.programs.Expression;
import jumpingalien.model.programs.expressions.data.DataExpression;
import jumpingalien.model.programs.expressions.data.DoubleConstExpr;
import jumpingalien.part3.programs.SourceLocation;

/**
 * Created by covert on 14/08/15.
 */
public class DivisonExpr extends OperatorExpression {
    public DivisonExpr(SourceLocation sourceLocation,Expression<Double> expr1, Expression<Double> expr2) {
        super(sourceLocation,expr1, expr2);
    }

    @Override
    public DoubleConstExpr getValue() {
        return new DoubleConstExpr(getSourceLocation(),((double)getExprOne().getValue() / (double) getExprTwo().getValue()));
    }
}
