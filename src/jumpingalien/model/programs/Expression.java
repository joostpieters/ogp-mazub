package jumpingalien.model.programs;

import jumpingalien.part3.programs.SourceLocation;

/**
 * Created by covert on 14/08/15.
 */
public abstract class Expression<dataType>
{
	private SourceLocation source;

	public Expression(SourceLocation sourceLocation)
	{
		source = sourceLocation;
	}

	public abstract dataType getValue(Environment env);

	public SourceLocation getSourceLocation()
	{
		return source;
	}
}
