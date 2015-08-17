package jumpingalien.model.programs.expressions.equation;

import jumpingalien.model.programs.Environment;
import jumpingalien.model.programs.Expression;
import jumpingalien.model.programs.expressions.data.DoubleConstExpr;
import jumpingalien.part3.programs.SourceLocation;

public abstract class EquationExpression extends Expression<Boolean>
{
	private final Expression<Double> doubleOne;
	private final Expression<Double> doubleTwo;

	EquationExpression(SourceLocation sourceLocation, Expression<Double> double1, Expression<Double> double2)
	{
		super(sourceLocation);
		doubleOne = double1;
		doubleTwo = double2;
	}

	protected abstract boolean exec(double dOne, double dTwo);

	public Boolean getValue(Environment env)
	{
		return exec(doubleOne.getValue(env), doubleTwo.getValue(env));
	}
}
