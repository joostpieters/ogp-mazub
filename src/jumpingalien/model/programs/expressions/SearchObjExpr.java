package jumpingalien.model.programs.expressions;

import jumpingalien.model.ActiveObject;
import jumpingalien.model.programs.Environment;
import jumpingalien.model.programs.Expression;
import jumpingalien.part3.programs.IProgramFactory;
import jumpingalien.part3.programs.SourceLocation;

import java.util.Collection;
import java.util.Comparator;
import java.util.PriorityQueue;

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
		Comparator<ActiveObject> comparator = new locationComparator(env.getActiveCaller(), directionExpression.getValue(env));
		PriorityQueue<ActiveObject> priorityQueue = new PriorityQueue<>(1, comparator);
		priorityQueue.addAll((Collection<? extends ActiveObject>) env.getwCaller().getCollection(ActiveObject.class));
		return priorityQueue.poll();

	}
}
