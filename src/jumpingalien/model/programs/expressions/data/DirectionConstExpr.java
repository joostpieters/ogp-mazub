package jumpingalien.model.programs.expressions.data;

import jumpingalien.part3.programs.IProgramFactory;
import jumpingalien.part3.programs.SourceLocation;

public class DirectionConstExpr extends DataExpression<IProgramFactory.Direction>
{
	public DirectionConstExpr(SourceLocation sourceLocation, IProgramFactory.Direction direction)
	{
		super(sourceLocation, direction);
	}
}
