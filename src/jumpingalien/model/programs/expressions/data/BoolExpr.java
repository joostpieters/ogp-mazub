package jumpingalien.model.programs.expressions.data;

import jumpingalien.part3.programs.SourceLocation;

public class BoolExpr extends DataExpression<Boolean>
{
	public BoolExpr(SourceLocation source, Boolean data)
	{
		super(source, data);
	}
}
