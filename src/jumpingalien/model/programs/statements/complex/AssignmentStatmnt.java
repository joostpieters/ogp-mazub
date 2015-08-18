package jumpingalien.model.programs.statements.complex;

import jumpingalien.model.programs.Environment;
import jumpingalien.model.programs.Expression;
import jumpingalien.model.programs.Type;
import jumpingalien.part3.programs.SourceLocation;

public class AssignmentStatmnt extends ComplexStatement
{
	private final String key;
	private final Type type;
	private final Expression value;

	public AssignmentStatmnt(SourceLocation sourceLocation, String variableName, Type variableType, Expression valueExpression)
	{
		super(sourceLocation);
		key = variableName;
		type = variableType;
		value = valueExpression;
	}

	public void exe(Environment env)
	{
		env.setVariable(key, value.getValue(env));
	}
}
