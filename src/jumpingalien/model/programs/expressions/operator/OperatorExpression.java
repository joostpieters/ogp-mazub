package jumpingalien.model.programs.expressions.operator;

import jumpingalien.model.programs.Expression;
import jumpingalien.model.programs.expressions.data.DataExpression;
import jumpingalien.model.programs.expressions.data.DoubleConstExpr;
import jumpingalien.part3.programs.SourceLocation;

/**
 * Created by covert on 14/08/15.
 */
public abstract class OperatorExpression implements Expression {
    private Expression exprOne,exprTwo;
    public OperatorExpression(Expression expr1, Expression expr2) {
        exprOne = expr1;exprTwo=expr2;
    }

    public Expression getExprOne() {
        return exprOne;
    }

    public Expression getExprTwo() {
        return exprTwo;
    }

    public abstract DoubleConstExpr getValue();
}