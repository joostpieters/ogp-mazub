package jumpingalien.model.programs.statements.complex;

import jumpingalien.model.*;
import jumpingalien.model.programs.Environment;
import jumpingalien.model.programs.Expression;
import jumpingalien.model.programs.Statement;
import jumpingalien.part3.programs.IProgramFactory;
import jumpingalien.part3.programs.SourceLocation;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;

public class ForEachStatmnt extends ConditionStatmnt
{
	private final String key;
	private final Expression sortExpression;
	private final IProgramFactory.SortDirection sortDirection;
	private final IProgramFactory.Kind kind;
	private final Statement bodyStatement;
	private ArrayList<ActiveObject> activeObjetcs;
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
		getActiveObjects(env);
		env.setVariable(key, activeObjetcs.get(activeIterate));

		assert (activeObjetcs.size() - 1 > activeIterate);
		env.backStack();
		activeIterate++;
		if (testCondition(env)) {
			env.backStack();
			env.intoStack(bodyStatement);
		}
	}

	private void getActiveObjects(Environment env) {
		if (activeObjetcs == null || activeObjetcs.size() < 1)
		{
			activeIterate = 0;
			switch (kind)
			{
				case MAZUB:
					final ArrayList<ActiveObject> finalActiveObjects = new ArrayList<>();
					env.getwCaller().getCollection(Mazub.class).parallelStream().filter(obj ->
									!(obj instanceof Buzam)
					).forEach(obj -> {
						finalActiveObjects.add((ActiveObject) obj);
					});
					activeObjetcs = finalActiveObjects;
					break;
				case BUZAM:
					activeObjetcs = (ArrayList<ActiveObject>) env.getwCaller().getCollection(Buzam.class);
					break;
				case SLIME:
					break;
				case SHARK:
					activeObjetcs = (ArrayList<ActiveObject>) env.getwCaller().getCollection(Shark.class);
					break;
				case PLANT:
					activeObjetcs = (ArrayList<ActiveObject>) env.getwCaller().getCollection(Plant.class);
					break;
				case TERRAIN:
					throw new NotImplementedException();
				case ANY:
					System.out.println("ANY Kind required, continue to default");
				default:
					activeObjetcs = (ArrayList<ActiveObject>) env.getwCaller().getCollection(ActiveObject.class);
					break;
			}
		}
	}
}
