package jumpingalien.model.programs.expressions.equation;

import jumpingalien.model.programs.Expression;
import jumpingalien.model.programs.expressions.data.BoolExpr;
import jumpingalien.model.programs.expressions.data.DoubleConstExpr;
import jumpingalien.part3.programs.SourceLocation;

/**
 * Created by covert on 15/08/15.
 */
public abstract class EquationExpression extends Expression<BoolExpr> {
    private Expression<Double> doubleOne, doubleTwo;
    public EquationExpression(SourceLocation sourceLocation, Expression<Double> double1 , Expression<Double> double2) {
        super(sourceLocation);
        doubleOne = double1;doubleTwo = double2;
    }
    public abstract boolean equate(double dOne, double dTwo);
    public BoolExpr getValue(){
        return new BoolExpr(getSourceLocation(),equate(doubleOne.getValue(),doubleTwo.getValue()));
    };
}
