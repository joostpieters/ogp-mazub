package jumpingalien.model.programs.expressions.object;

import jumpingalien.model.ActiveObject;
import jumpingalien.model.programs.Expression;
import jumpingalien.part3.programs.SourceLocation;

public class GetHitPointsExpr extends ObjectExpression
{
	public GetHitPointsExpr(SourceLocation sourceLocation, Expression<ActiveObject> obj)
	{
		super(sourceLocation, obj);
	}

	protected Double exec(ActiveObject activeObject)
	{
		return Double.valueOf(activeObject.getHealth());
	}
}

