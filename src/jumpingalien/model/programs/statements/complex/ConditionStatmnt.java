package jumpingalien.model.programs.statements.complex;

import jumpingalien.model.programs.Environment;
import jumpingalien.model.programs.Expression;
import jumpingalien.part3.programs.SourceLocation;

public abstract class ConditionStatmnt extends ComplexStatement
{
	private final Expression<Boolean> condition;

	ConditionStatmnt(SourceLocation sourceLocation, Expression<Boolean> conditionExpression)
	{
		super(sourceLocation);
		condition = conditionExpression;
	}

	boolean testCondition(Environment env)
	{
		return condition.getValue(env);
	}

	public abstract void exe(Environment env);
}
