package jumpingalien.model.programs.statements.complex;

import jumpingalien.model.programs.Environment;
import jumpingalien.model.programs.Expression;
import jumpingalien.model.programs.Statement;
import jumpingalien.part3.programs.SourceLocation;

public class WhileStatmnt extends ConditionStatmnt
{
	private final Statement whileBody;

	public WhileStatmnt(SourceLocation sourceLocation, Expression<Boolean> conditionExpression, Statement body)
	{
		super(sourceLocation, conditionExpression);
		whileBody = body;
	}

	public void exe(Environment env)
	{
		if (testCondition(env))
		{
			env.backStack();
			env.intoStack(whileBody);//TODO refactor
		}
	}
}
