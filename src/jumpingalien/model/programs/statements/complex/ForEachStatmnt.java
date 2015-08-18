package jumpingalien.model.programs.statements.complex;

import jumpingalien.model.*;
import jumpingalien.model.programs.Environment;
import jumpingalien.model.programs.Expression;
import jumpingalien.model.programs.Statement;
import jumpingalien.part3.programs.IProgramFactory;
import jumpingalien.part3.programs.SourceLocation;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Collection;
import java.util.LinkedList;

public class ForEachStatmnt extends ConditionStatmnt
{
	private final String key;
	private final Expression sortExpression;
	private final IProgramFactory.SortDirection sortDirection;
	private final IProgramFactory.Kind kind;
	private final Statement bodyStatement;
	private LinkedList<ActiveObject> activeObjetcs;
	private int activeIterate;

	public ForEachStatmnt(SourceLocation sourceLocation, String name, IProgramFactory.Kind variableKind, Expression<Boolean> where, Expression sort
			, IProgramFactory.SortDirection sortDir, Statement body)
	{
		super(sourceLocation, where);
		key = name;
		kind = variableKind;
		sortExpression = sort;
		sortDirection = sortDir;
		bodyStatement = body;
	}

	public void exe(Environment env)
	{
//TODO
	}

	private void initialiseObjects(Environment env) {
		activeIterate = 0;

		Collection<ActiveObject> activeObjectsColl = new LinkedList<>();

		switch (kind) {
			case MAZUB:
				final LinkedList<ActiveObject> finalActiveObjects = new LinkedList<>();
				env.getwCaller().getCollection(Mazub.class).parallelStream().filter(obj ->
					!(obj instanceof Buzam)
						).forEach(obj -> {
					finalActiveObjects.add((ActiveObject) obj);
				});
				activeObjectsColl = finalActiveObjects;
				break;
			case BUZAM:
				activeObjectsColl = (Collection<ActiveObject>) env.getwCaller().getCollection(Buzam.class);
				break;
			case SLIME:
				break;
			case SHARK:
				activeObjectsColl = (Collection<ActiveObject>) env.getwCaller().getCollection(Shark.class);
				break;
			case PLANT:
				activeObjectsColl = (Collection<ActiveObject>) env.getwCaller().getCollection(Plant.class);
				break;
			case TERRAIN:
				throw new NotImplementedException();
			case ANY:
				System.out.println("ANY Kind required, continue to default");
			default:
				activeObjectsColl = (Collection<ActiveObject>) env.getwCaller().getCollection(ActiveObject.class);
				break;
		}

		if (activeObjectsColl != null) {
			activeObjetcs = (LinkedList<ActiveObject>) activeObjectsColl;
		}
	}
	private void doLoop(Environment env) {
		if (activeObjetcs == null || activeObjetcs.size() < 1) {
			initialiseObjects(env);
			return;
		}

		env.setVariable(key, activeObjetcs.get(activeIterate));

		if (activeIterate < activeObjetcs.size() - 1) {
			env.backStack();
			activeIterate++;
		} else {
			initialiseObjects(env);
		}

		if (testCondition(env)) {
			env.backStack();
			env.intoStack(bodyStatement);
		}
	}
}
