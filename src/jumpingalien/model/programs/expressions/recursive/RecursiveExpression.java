package jumpingalien.model.programs.expressions.recursive;

import jumpingalien.model.programs.Environment;
import jumpingalien.model.programs.Expression;
import jumpingalien.part3.programs.SourceLocation;

public abstract class RecursiveExpression extends Expression<Double>
{
	private final Expression<Double> internalExpression;

	RecursiveExpression(SourceLocation source, Expression<Double> expression)
	{
		super(source);
		internalExpression = expression;
	}

	Expression<Double> getInternalExpression()
	{
		return internalExpression;
	}

	public abstract Double getValue(Environment env);
}
