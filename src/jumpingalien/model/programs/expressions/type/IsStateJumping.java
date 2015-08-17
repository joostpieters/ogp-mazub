package jumpingalien.model.programs.expressions.type;

import jumpingalien.model.ActiveObject;
import jumpingalien.model.programs.Expression;
import jumpingalien.part3.programs.SourceLocation;

public class IsStateJumping extends IsState
{
	public IsStateJumping(SourceLocation sourceLocation, Expression obj)
	{
		super(sourceLocation, obj);
	}

	protected boolean checkState(ActiveObject activeObject)
	{
		return activeObject.isJumping();
	}
}
