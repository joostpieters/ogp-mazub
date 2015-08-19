package jumpingalien.model.programs.expressions.equation;

import jumpingalien.model.programs.Environment;
import jumpingalien.model.programs.Expression;
import jumpingalien.part3.programs.SourceLocation;

public class EqualExpr extends Expression<Boolean>
{
	private Expression exprOne, exprTwo;

	public EqualExpr(SourceLocation sourceLocation, Expression expr1, Expression expr2)
	{
		super(sourceLocation);
		exprOne = expr1;
		exprTwo = expr2;
	}


	@Override
	public Boolean getValue(Environment env)
	{
		return (exprOne.getValue(env) == exprTwo.getValue(env));
	}
}
