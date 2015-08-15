package jumpingalien.model.programs.expressions.equation;

import jumpingalien.model.programs.Expression;
import jumpingalien.model.programs.expressions.data.DoubleConstExpr;
import jumpingalien.part3.programs.SourceLocation;

/**
 * Created by covert on 14/08/15.
 */
public class LessThanExpr extends EquationExpression {
    public LessThanExpr(SourceLocation sourceLocation, Expression<Double> double1, Expression<Double> double2) {
        super(sourceLocation, double1, double2);
    }

    public boolean exec(double dOne, double dTwo) {
        return dOne < dTwo;
    }
}
