package jumpingalien.model.programs.expressions.operator;

import jumpingalien.model.programs.Expression;
import jumpingalien.part3.programs.SourceLocation;

/**
 * Created by covert on 14/08/15.
 */
public class MultiplicationExpr extends OperatorExpression
{
	public MultiplicationExpr(SourceLocation source, Expression<Double> expr1, Expression<Double> expr2)
	{
		super(source, expr1, expr2);
	}

	protected double exec(double exprOne, double exprTwo)
	{
		return exprOne * exprTwo;
	}

}
