package jumpingalien.model.programs.statements.complex;

import jumpingalien.model.programs.Environment;
import jumpingalien.part3.programs.SourceLocation;

public class FunctionExeStatmnt extends ComplexStatement
{
	String key;

	FunctionExeStatmnt(SourceLocation sourceLocation, String name)
	{
		super(sourceLocation);
		key = name;
	}

	public void exe(Environment env)
	{
		env.getFunction(key).exe(env);
	}
}
