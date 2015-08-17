package jumpingalien.model.programs.expressions.type;

import jumpingalien.model.ActiveObject;
import jumpingalien.model.Slime;
import jumpingalien.model.programs.Expression;
import jumpingalien.part3.programs.SourceLocation;

public class IsSlimeExpr extends TypeExpression
{
	public IsSlimeExpr(SourceLocation sourceLocation, Expression<ActiveObject> obj)
	{
		super(sourceLocation, obj);
	}


	protected boolean exec(Object obj)
	{
		return obj instanceof Slime;
	}
}
