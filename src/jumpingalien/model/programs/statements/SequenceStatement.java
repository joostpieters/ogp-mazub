package jumpingalien.model.programs.statements;

import jumpingalien.model.programs.Environment;
import jumpingalien.model.programs.Statement;
import jumpingalien.part3.programs.SourceLocation;

import java.util.List;

public class SequenceStatement extends Statement
{
	private final List<Statement> statementList;

	public SequenceStatement(SourceLocation sourceLocation, List<Statement> statements)
	{
		super(sourceLocation);
		statementList = statements;
	}

	public void exe(Environment env)
	{
		for (Statement statement : statementList)
		{
			statement.exe(env);
		}
		//statementList.stream().forEach(obj -> obj.exe(env));
	}

	public List<Statement> getStatementList()
	{
		return statementList;
	}
}
