package jumpingalien.model.programs.expressions;

import jumpingalien.model.ActiveObject;
import jumpingalien.model.programs.Environment;
import jumpingalien.model.programs.Expression;
import jumpingalien.model.programs.expressions.data.DoubleConstExpr;
import jumpingalien.part3.programs.SourceLocation;

class SelfExpr extends Expression<ActiveObject>
{
	protected SelfExpr(SourceLocation sourceLocation)
	{
		super(sourceLocation);
	}

	@Override
	public ActiveObject getValue(Environment env)
	{
		return env.getActiveCaller();
	}
}
