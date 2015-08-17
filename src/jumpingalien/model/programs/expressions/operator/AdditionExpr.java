package jumpingalien.model.programs.expressions.operator;

import jumpingalien.model.programs.Expression;
import jumpingalien.part3.programs.SourceLocation;

public class AdditionExpr extends OperatorExpression
{
	public AdditionExpr(SourceLocation sourceLocation, Expression<Double> exprOne, Expression<Double> exprTwo)
	{
		super(sourceLocation, exprOne, exprTwo);
	}

	protected double exec(double exprOne, double exprTwo)
	{
		return exprOne + exprTwo;
	}

}
