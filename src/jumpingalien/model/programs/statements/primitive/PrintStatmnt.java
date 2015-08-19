package jumpingalien.model.programs.statements.primitive;

import jumpingalien.model.programs.Environment;
import jumpingalien.model.programs.Expression;
import jumpingalien.part3.programs.SourceLocation;

public class PrintStatmnt extends PrimitiveStatement
{
	public PrintStatmnt(SourceLocation sourceLocation, Expression exp)
	{
		super(sourceLocation, exp);
	}

	protected void exec(Environment env, Expression expression)
	{
		System.out.println(expression.getValue(env));
	}
}
