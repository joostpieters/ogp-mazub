package jumpingalien.model.programs.statements.complex;

import jumpingalien.model.programs.Environment;
import jumpingalien.model.programs.Statement;
import jumpingalien.part3.programs.SourceLocation;

import java.util.Iterator;

/**
 * Created by covert on 16/08/15.
 */
public abstract class ComplexStatement extends Statement
{
	Iterator<Statement> statementIterator;//TODO

	public ComplexStatement(SourceLocation sourceLocation)
	{
		super(sourceLocation);
	}

	public abstract void exe(Environment env);
}
