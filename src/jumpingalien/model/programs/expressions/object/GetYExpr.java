package jumpingalien.model.programs.expressions.object;

import jumpingalien.model.ActiveObject;
import jumpingalien.model.programs.Expression;
import jumpingalien.part3.programs.SourceLocation;

public class GetYExpr extends ObjectExpression
{
	public GetYExpr(SourceLocation sourceLocation, Expression<ActiveObject> obj)
	{
		super(sourceLocation, obj);
	}


	protected Double exec(ActiveObject activeObject)
	{
		return activeObject.getRawLocation()[1];
	}
}
