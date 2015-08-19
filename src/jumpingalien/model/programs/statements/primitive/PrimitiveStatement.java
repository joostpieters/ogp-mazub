package jumpingalien.model.programs.statements.primitive;

import jumpingalien.model.programs.Environment;
import jumpingalien.model.programs.Expression;
import jumpingalien.model.programs.Statement;
import jumpingalien.part3.programs.SourceLocation;

public abstract class PrimitiveStatement<dataType> extends Statement
{
	private Expression<dataType> expression;

	PrimitiveStatement(SourceLocation sourceLocation, Expression<dataType> exp)
	{
		super(sourceLocation);
		expression = exp;
	}

	PrimitiveStatement(SourceLocation sourceLocation)
	{
		super(sourceLocation);
	}

	protected abstract void exec(Environment env, Expression<dataType> expression);

	public void exe(Environment env)
	{

		exec(env, expression);

	}
}
