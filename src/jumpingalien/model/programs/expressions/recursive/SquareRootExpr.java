package jumpingalien.model.programs.expressions.recursive;

import jumpingalien.model.programs.Environment;
import jumpingalien.model.programs.Expression;
import jumpingalien.part3.programs.SourceLocation;

public class SquareRootExpr extends RecursiveExpression
{
	public SquareRootExpr(SourceLocation source, Expression<Double> expression)
	{
		super(source, expression);
	}

	public Double getValue(Environment en)
	{
		return Math.sqrt(getInternalExpression().getValue(en));
	}
}
