package jumpingalien.model.programs.statements.primitive;

import jumpingalien.model.programs.Environment;
import jumpingalien.model.programs.Expression;
import jumpingalien.part3.programs.IProgramFactory;
import jumpingalien.part3.programs.SourceLocation;

public class StartRunExpr extends PrimitiveStatement<IProgramFactory.Direction>
{
	public StartRunExpr(SourceLocation sourceLocation, Expression<IProgramFactory.Direction> exp)
	{
		super(sourceLocation, exp);
	}

	protected void exec(Environment env, Expression<IProgramFactory.Direction> expression)
	{
		switch (expression.getValue(env))
		{
			case LEFT:
				env.getActiveCaller().startMoveLeft();
				break;
			case RIGHT:
				env.getActiveCaller().startMoveRight();
				break;
			case UP:
				throw new IllegalArgumentException("can only move right or left not up");
			case DOWN:
				throw new IllegalArgumentException("can only move right or left not down");
		}
	}
}
