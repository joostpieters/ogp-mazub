package jumpingalien.model.programs.expressions.type;

import jumpingalien.model.ActiveObject;
import jumpingalien.model.programs.Expression;
import jumpingalien.part3.programs.SourceLocation;

/**
 * Created by covert on 16/08/15.
 */
public abstract class IsState extends TypeExpression
{
	public IsState(SourceLocation sourceLocation, Expression obj)
	{
		super(sourceLocation, obj);
	}

	protected abstract boolean checkState(ActiveObject activeObject);

	protected boolean exec(Object obj)
	{
		assert obj instanceof ActiveObject;
		ActiveObject activeObject = (ActiveObject) obj;
		return checkState(activeObject);
	}
}
