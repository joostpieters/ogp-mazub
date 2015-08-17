package jumpingalien.model.programs.expressions.equation;

import jumpingalien.model.programs.Environment;
import jumpingalien.model.programs.Expression;
import jumpingalien.part3.programs.SourceLocation;

/**
 * Created by covert on 15/08/15.
 */
public abstract class EquationExpression extends Expression<Boolean> {
    private Expression<Double> doubleOne, doubleTwo;
    public EquationExpression(SourceLocation sourceLocation, Expression<Double> double1 , Expression<Double> double2) {
        super(sourceLocation);
        doubleOne = double1;doubleTwo = double2;
    }
    protected abstract boolean exec(double dOne, double dTwo);
    public Boolean getValue(Environment env){
        return exec(doubleOne.getValue(env), doubleTwo.getValue(env));
    };
}
