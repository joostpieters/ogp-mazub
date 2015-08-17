package jumpingalien.model.programs.statements.primitive;

import jumpingalien.model.programs.Environment;
import jumpingalien.model.programs.Expression;
import jumpingalien.part3.programs.SourceLocation;

public class WaitStatmnt extends PrimitiveStatement<Double>
{
	private double waited = 1;

	public WaitStatmnt(SourceLocation sourceLocation, Expression<Double> exp)
	{
		super(sourceLocation, exp);
	}

	protected void doAction(Environment env, Expression<Double> expression)
	{
		if (waited < expression.getValue(env))
		{
			waited++;
			env.stepBack();
		} else
		{
			waited = 1;
		}

		//TODO refactor
	}
}
