package jumpingalien.model.programs;

import jumpingalien.part3.programs.SourceLocation;

public abstract class Statement
{
	private final SourceLocation sourceLocation;

	public Statement(SourceLocation sourceLocation)
	{
		this.sourceLocation = sourceLocation;
	}

	public SourceLocation getSourceLocation()
	{
		return sourceLocation;
	}

	public abstract void exe(Environment env);
}
