package jumpingalien.model.programs.expressions.operator;

import jumpingalien.model.programs.Environment;
import jumpingalien.model.programs.Expression;
import jumpingalien.part3.programs.SourceLocation;

public abstract class OperatorExpression extends Expression<Double>
{
	private final Expression<Double> exprOne;
	private final Expression<Double> exprTwo;

	OperatorExpression(SourceLocation sourceLocation, Expression<Double> expr1, Expression<Double> expr2)
	{
		super(sourceLocation);
		exprOne = expr1;
		exprTwo = expr2;
	}

	protected abstract double exec(double exprOne, double exprTwo);

	public Double getValue(Environment env)
	{
		return exec(exprOne.getValue(env), exprTwo.getValue(env));
	}
}
