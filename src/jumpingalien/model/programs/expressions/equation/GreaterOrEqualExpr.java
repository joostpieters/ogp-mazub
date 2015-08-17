package jumpingalien.model.programs.expressions.equation;

import jumpingalien.model.programs.Expression;
import jumpingalien.part3.programs.SourceLocation;

public class GreaterOrEqualExpr extends EquationExpression
{
	public GreaterOrEqualExpr(SourceLocation sourceLocation, Expression<Double> double1, Expression<Double> double2)
	{
		super(sourceLocation, double1, double2);
	}

	protected boolean exec(double dOne, double dTwo)
	{
		return dOne >= dTwo;
	}
}
