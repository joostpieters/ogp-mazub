package jumpingalien.model.programs.expressions.type;

import jumpingalien.model.programs.Environment;
import jumpingalien.model.programs.Expression;
import jumpingalien.part3.programs.SourceLocation;

public abstract class TypeExpression extends Expression<Boolean>
{
	private final Expression ObjectExpression;

	TypeExpression(SourceLocation sourceLocation, Expression obj)
	{
		super(sourceLocation);
		ObjectExpression = obj;
	}

	protected Expression getObjectExpression()
	{
		return ObjectExpression;
	}

	protected abstract boolean exec(Object obj);

	public Boolean getValue(Environment env)
	{
		return exec(ObjectExpression.getValue(env));
	}
}
