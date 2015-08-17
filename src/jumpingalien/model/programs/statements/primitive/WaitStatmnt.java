package jumpingalien.model.programs.statements.primitive;

import jumpingalien.model.programs.Environment;
import jumpingalien.model.programs.Expression;
import jumpingalien.part3.programs.SourceLocation;

/**
 * Created by covert on 16/08/15.
 */
public class WaitStatmnt extends PrimitiveStatement<Double>
{
	double waited = 1;

	public WaitStatmnt(SourceLocation sourceLocation, Expression<Double> exp)
	{
		super(sourceLocation, exp);
	}

	protected void doAction(Environment env, Expression<Double> expression)
	{
		if (waited - expression.getValue(env) < 0)
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
