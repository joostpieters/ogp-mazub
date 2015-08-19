package jumpingalien.model.programs.statements.complex;

import jumpingalien.model.programs.Environment;
import jumpingalien.model.programs.Statement;
import jumpingalien.part3.programs.SourceLocation;

public class FunctionAssignmentStatmnt extends ComplexStatement
{
	Statement functionBody;
	String key;

	public FunctionAssignmentStatmnt(SourceLocation sourceLocation, String name, Statement statement)
	{
		super(sourceLocation);
		key = name;
		functionBody = statement;
	}

	@Override
	public void exe(Environment env)
	{
		env.setFunction(key, functionBody);
	}
}
