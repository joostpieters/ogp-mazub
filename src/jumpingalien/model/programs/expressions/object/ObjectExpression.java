package jumpingalien.model.programs.expressions.object;

import jumpingalien.model.ActiveObject;
import jumpingalien.model.programs.Environment;
import jumpingalien.model.programs.Expression;
import jumpingalien.part3.programs.SourceLocation;

public abstract class ObjectExpression extends Expression<Double>
{
	private final Expression<ActiveObject> activeObject;

	ObjectExpression(SourceLocation sourceLocation, Expression<ActiveObject> obj)
	{
		super(sourceLocation);
		activeObject = obj;
	}

	protected abstract double exec(ActiveObject activeObject);


	public Double getValue(Environment env)
	{
		return exec(activeObject.getValue(env));
	}
}
