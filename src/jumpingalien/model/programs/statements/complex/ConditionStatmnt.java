package jumpingalien.model.programs.statements.complex;

import jumpingalien.model.programs.Environment;
import jumpingalien.model.programs.Expression;
import jumpingalien.part3.programs.SourceLocation;

/**
 * Created by covert on 16/08/15.
 */
public abstract class ConditionStatmnt extends ComplexStatement
{
	Expression<Boolean> condition;

	public ConditionStatmnt(SourceLocation sourceLocation, Expression<Boolean> conditionExpression)
	{
		super(sourceLocation);
		condition = conditionExpression;
	}

	protected boolean testCondition(Environment env)
	{
		return condition.getValue(env);
	}

	public abstract void exe(Environment env);
}
