package jumpingalien.model.programs.expressions.equation;

import jumpingalien.model.programs.Expression;
import jumpingalien.part3.programs.SourceLocation;

public class GreaterThanExpr extends EquationExpression
{

	public GreaterThanExpr(SourceLocation sourceLocation, Expression<Double> double1, Expression<Double> double2)
	{
		super(sourceLocation, double1, double2);
	}

	protected boolean exec(double dOne, double dTwo)
	{
		return dOne > dTwo;
	}

}
