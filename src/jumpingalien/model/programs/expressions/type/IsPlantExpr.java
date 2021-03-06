package jumpingalien.model.programs.expressions.type;

import jumpingalien.model.ActiveObject;
import jumpingalien.model.Plant;
import jumpingalien.model.programs.Expression;
import jumpingalien.part3.programs.SourceLocation;

public class IsPlantExpr extends TypeExpression
{
	public IsPlantExpr(SourceLocation sourceLocation, Expression<ActiveObject> obj)
	{
		super(sourceLocation, obj);
	}

	protected boolean exec(Object obj)
	{
		return obj instanceof Plant;
	}
}
