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

	@Override
	public Boolean getValue(Environment en)
	{
		return exec(obj, en);
	}

	private boolean exec(Object obj, Environment en)
	{
		assert obj instanceof ActiveObject;
		ActiveObject activeObject = (ActiveObject) obj;
		return checkState(activeObject, en);
	}

	private boolean checkState(ActiveObject activeObject, Environment en)
	{
		switch (di.getValue(en))
		{

			case LEFT:
				return (activeObject.getVelocity()[0] < 0);
			case RIGHT:
				return (activeObject.getVelocity()[0] > 0);
			case UP:
				return (activeObject.getVelocity()[1] > 0);
			case DOWN:
				return (activeObject.getVelocity()[1] < 0);
			default:
				return false;
		}
	}
}
