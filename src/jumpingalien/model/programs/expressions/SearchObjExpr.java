package jumpingalien.model.programs.expressions;

import jumpingalien.model.ActiveObject;
import jumpingalien.model.programs.Environment;
import jumpingalien.model.programs.Expression;
import jumpingalien.part3.programs.IProgramFactory;
import jumpingalien.part3.programs.SourceLocation;

public class SearchObjExpr extends Expression<ActiveObject>
{
	private final Expression<IProgramFactory.Direction> directionExpression;

	public SearchObjExpr(SourceLocation sourceLocation, Expression<IProgramFactory.Direction> direction)
	{
		super(sourceLocation);
		directionExpression = direction;
	}

	public ActiveObject getValue(Environment env)
	{

		return null;//TODO
	}
}
