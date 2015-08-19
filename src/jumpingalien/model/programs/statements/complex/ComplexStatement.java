package jumpingalien.model.programs.statements.complex;

import jumpingalien.model.programs.Environment;
import jumpingalien.model.programs.Statement;
import jumpingalien.part3.programs.SourceLocation;

public abstract class ComplexStatement extends Statement
{
	ComplexStatement(SourceLocation sourceLocation)
	{
		super(sourceLocation);
	}

	public abstract void exe(Environment env);
}
