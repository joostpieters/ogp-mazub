package jumpingalien.model.programs.expressions.data;

import jumpingalien.part3.programs.SourceLocation;

/**
 * Created by covert on 14/08/15.
 */
public class NullExpr extends DataExpression
{
	public NullExpr(SourceLocation sourceLocation)
	{
		super(sourceLocation, null);
	}
}
