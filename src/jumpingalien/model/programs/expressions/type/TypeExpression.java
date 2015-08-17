package jumpingalien.model.programs.expressions.type;

import jumpingalien.model.programs.Environment;
import jumpingalien.model.programs.Expression;
import jumpingalien.part3.programs.SourceLocation;

/**
 * Created by covert on 15/08/15.
 */
public abstract class TypeExpression extends Expression<Boolean>
{
	private Expression ObjectExpression;

	public TypeExpression(SourceLocation sourceLocation, Expression obj)
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
