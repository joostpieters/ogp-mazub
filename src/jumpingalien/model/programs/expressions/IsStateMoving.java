package jumpingalien.model.programs.expressions;

import jumpingalien.model.ActiveObject;
import jumpingalien.model.programs.Environment;
import jumpingalien.model.programs.Expression;
import jumpingalien.part3.programs.IProgramFactory;
import jumpingalien.part3.programs.SourceLocation;

public class IsStateMoving extends Expression<Boolean>
{
	private final Expression<IProgramFactory.Direction> di;
	private final Expression<ActiveObject> obj;

	public IsStateMoving(SourceLocation sourceLocation, Expression<ActiveObject> activeObjectExpression, Expression<IProgramFactory.Direction> direction)
	{
		super(sourceLocation);
		di = direction;
		obj = activeObjectExpression;
	}

	public Boolean getValue(Environment en)
	{
		return exec(obj.getValue(en), en);
	}

	private boolean exec(ActiveObject obj, Environment en)
	{
		switch (di.getValue(en))
		{
			case LEFT:
				return (en.getActiveCaller().getHorDirection() == ActiveObject.enHorState.left);
			case RIGHT:
				return (en.getActiveCaller().getHorDirection() == ActiveObject.enHorState.right);
			case UP:
				return (en.getActiveCaller().getVerDirection() == ActiveObject.enVertState.jump);
			case DOWN:
				return (en.getActiveCaller().getVerDirection() == ActiveObject.enVertState.duck);
			default:
				return false;
		}
	}
}
