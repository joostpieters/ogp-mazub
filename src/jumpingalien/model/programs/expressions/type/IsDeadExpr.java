package jumpingalien.model.programs.expressions.type;

import jumpingalien.model.ActiveObject;
import jumpingalien.model.programs.Expression;
import jumpingalien.part3.programs.SourceLocation;

public class IsDeadExpr extends TypeExpression
{
	public IsDeadExpr(SourceLocation sourceLocation, Expression<ActiveObject> obj)
	{
		super(sourceLocation, obj);
	}


	protected boolean exec(Object obj)
	{
		ActiveObject activeObject = (ActiveObject) obj;
		return activeObject.getHealth() < 1;
	}
}
