package jumpingalien.model.programs.statements.primitive;

import jumpingalien.model.programs.Environment;
import jumpingalien.model.programs.Expression;
import jumpingalien.part3.programs.SourceLocation;

public class StopJumpStatmnt extends PrimitiveStatement
{
	public StopJumpStatmnt(SourceLocation sourceLocation)
	{
		super(sourceLocation);
	}

	protected void exec(Environment env, Expression expression)
	{
		env.getActiveCaller().endJump();
	}
}
