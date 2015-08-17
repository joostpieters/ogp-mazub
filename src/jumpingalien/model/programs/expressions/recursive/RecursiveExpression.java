package jumpingalien.model.programs.expressions.recursive;

import jumpingalien.model.programs.Environment;
import jumpingalien.model.programs.Expression;
import jumpingalien.model.programs.expressions.data.DataExpression;
import jumpingalien.model.programs.expressions.data.DoubleConstExpr;
import jumpingalien.part3.programs.SourceLocation;

/**
 * Created by covert on 14/08/15.
 */
public abstract class RecursiveExpression extends Expression<Double> {
    Expression<Double> internalExpression;
    public RecursiveExpression(SourceLocation source, Expression<Double> expression) {
        super(source);
        internalExpression = expression;
    }

    protected Expression<Double> getInternalExpression(){
        return internalExpression;
    }

    public abstract Double getValue(Environment env);
}
