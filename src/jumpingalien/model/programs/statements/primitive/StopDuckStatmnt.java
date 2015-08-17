package jumpingalien.model.programs.statements.primitive;

import jumpingalien.model.programs.Environment;
import jumpingalien.model.programs.Expression;
import jumpingalien.part3.programs.SourceLocation;

/**
 * Created by covert on 16/08/15.
 */
public class StopDuckStatmnt extends PrimitiveStatement
{
	public StopDuckStatmnt(SourceLocation sourceLocation)
	{
		super(sourceLocation);
	}

	protected void doAction(Environment env, Expression expression)
	{
		env.getActiveCaller().endDuck();
	}
}
