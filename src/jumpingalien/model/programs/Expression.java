package jumpingalien.model.programs;

import jumpingalien.part3.programs.SourceLocation;

public abstract class Expression<dataType>
{
	private final SourceLocation source;

	protected Expression(SourceLocation sourceLocation)
	{
		source = sourceLocation;
	}

	public abstract dataType getValue(Environment env);

	protected SourceLocation getSourceLocation()
	{
		return source;
	}
}
