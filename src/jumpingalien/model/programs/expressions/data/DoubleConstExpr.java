package jumpingalien.model.programs.expressions.data;

import jumpingalien.part3.programs.SourceLocation;

public class DoubleConstExpr extends DataExpression<Double>
{
	public DoubleConstExpr(SourceLocation sourceLocation, Double data)
	{
		super(sourceLocation, data);
	}
}
