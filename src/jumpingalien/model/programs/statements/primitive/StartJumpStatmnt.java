package jumpingalien.model.programs.statements.primitive;

import jumpingalien.model.programs.Environment;
import jumpingalien.model.programs.Expression;
import jumpingalien.part3.programs.SourceLocation;

public class StartJumpStatmnt extends PrimitiveStatement
{
	public StartJumpStatmnt(SourceLocation sourceLocation)
	{
		super(sourceLocation);

	}

	protected void doAction(Environment env, Expression expression)
	{
		env.getActiveCaller().startJump();
	}
}
