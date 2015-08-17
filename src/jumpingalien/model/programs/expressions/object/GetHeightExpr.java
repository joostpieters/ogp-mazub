package jumpingalien.model.programs.expressions.object;

import jumpingalien.model.ActiveObject;
import jumpingalien.model.programs.Expression;
import jumpingalien.part3.programs.SourceLocation;

public class GetHeightExpr extends ObjectExpression
{
	public GetHeightExpr(SourceLocation sourceLocation, Expression<ActiveObject> obj)
	{
		super(sourceLocation, obj);
	}

	protected Double exec(ActiveObject activeObject)
	{
		return Double.valueOf(activeObject.getCurrentSprite().getHeight());
	}
}
