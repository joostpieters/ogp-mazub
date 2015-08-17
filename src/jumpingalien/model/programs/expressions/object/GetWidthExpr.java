package jumpingalien.model.programs.expressions.object;

import jumpingalien.model.ActiveObject;
import jumpingalien.model.programs.Expression;
import jumpingalien.part3.programs.SourceLocation;

public class GetWidthExpr extends ObjectExpression
{
	public GetWidthExpr(SourceLocation sourceLocation, Expression<ActiveObject> obj)
	{
		super(sourceLocation, obj);
	}


	protected double exec(ActiveObject activeObject)
	{
		return activeObject.getCurrentSprite().getWidth();
	}
}
