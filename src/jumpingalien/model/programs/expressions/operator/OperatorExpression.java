package jumpingalien.model.programs.expressions.operator;

import jumpingalien.model.programs.Environment;
import jumpingalien.model.programs.Expression;
import jumpingalien.model.programs.expressions.data.DataExpression;
import jumpingalien.model.programs.expressions.data.DoubleConstExpr;
import jumpingalien.part3.programs.SourceLocation;

/**
 * Created by covert on 14/08/15.
 */
public abstract class OperatorExpression extends Expression<DoubleConstExpr> {
    private Expression<Double> exprOne,exprTwo;
    public OperatorExpression(SourceLocation sourceLocation,Expression<Double> expr1, Expression<Double> expr2) {
        super(sourceLocation);
        exprOne = expr1;exprTwo=expr2;
    }

    protected abstract double exec(double exprOne, double exprTwo);

    public DoubleConstExpr getValue(Environment env){
        return new DoubleConstExpr(getSourceLocation(),exec(exprOne.getValue(env),exprTwo.getValue(env)));
    };
}
