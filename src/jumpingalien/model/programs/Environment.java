package jumpingalien.model.programs;

import jumpingalien.model.ActiveObject;
import jumpingalien.model.Program;
import jumpingalien.model.World;
import jumpingalien.model.programs.statements.SequenceStatement;
import jumpingalien.part3.programs.IProgramFactory;

import java.util.HashMap;
import java.util.Stack;

public class Environment
{
	private final ActiveObject activeCaller;
	private final Program programCaller;
	private final HashMap<String, Object> allVariables = new HashMap<>();
	private final Stack<Statement> statementStack = new Stack<>();
	private final Stack<Integer> stackCounter = new Stack<>();
	private final HashMap<String, Statement> allFunctions = new HashMap<>();

	public Environment(ActiveObject activeObject, Program program)
	{
		programCaller = program;
		activeCaller = activeObject;
		stackCounter.push(0);
		statementStack.push(program.getAllStatements());

		for (HashMap.Entry<String, Type> variable : program.getAllVars().entrySet())
		{
			String key = variable.getKey();
			Type type = variable.getValue();
			switch (type)
			{
				case ActiveObject:
					setVariable(key, null);
					continue;
				case Boolean:
					setVariable(key, false);
					continue;
				case Direction:
					setVariable(key, IProgramFactory.Direction.RIGHT);
					continue;
				case Double:
					setVariable(key, 0.0);
					continue;
			}
		}
	}

	public World getwCaller()
	{
		return activeCaller.getwCaller();
	}

	public ActiveObject getActiveCaller()
	{
		return activeCaller;
	}

	public void setVariable(String name, Object value)
	{
		allVariables.put(name, value);
	}
	public Object getVariable(String key)
	{
		return allVariables.get(key);
	}


	public void setFunction(String name,Statement expression){
		allFunctions.put(name,expression);
	}

	public Statement getFunction(String name){
		return allFunctions.get(name);
	}

	public Statement getStatement()
	{
		if (statementStack.isEmpty()) reset();
		if ( statementStack.peek() instanceof SequenceStatement)
		{
			SequenceStatement sequence = (SequenceStatement)  statementStack.peek();
			if (stackCounter.peek() >= sequence.getStatementList().size())
			{
				statementStack.pop();
				stackCounter.pop();
				return getStatement();
			} else
			{
				return sequence.getStatementList().get(stackCounter.peek());
			}
		} else
		{
			return statementStack.peek();
		}
	}
	private int getLocalStatementCount()
	{
		if (statementStack.peek() instanceof SequenceStatement)
		{
			SequenceStatement sequence = (SequenceStatement) statementStack.peek();
			return sequence.getStatementList().size();
		} else
		{
			return 1;
		}
	}

	public void continueStack()
	{
		if (stackCounter.peek() <= getLocalStatementCount() - 1)
		{
			int i = stackCounter.pop();
			stackCounter.push(i + 1);
		} else
		{
			backStack();
		}
	}

	public void backStack()
	{
		stackCounter.add(stackCounter.pop() + 1);
	}

	public void intoStack(Statement statement)
	{
		stackCounter.push(stackCounter.pop() + 1);
		stackCounter.push(-1);
		statementStack.push(statement);
	}


	private void reset()
	{
		stackCounter.clear();
		stackCounter.clear();
		allVariables.clear();
		statementStack.push(programCaller.getAllStatements());
		stackCounter.push(0);
		for (HashMap.Entry<String, Type> variable : programCaller.getAllVars().entrySet())
		{
			String key = variable.getKey();
			Type type = variable.getValue();

			switch (type)
			{
				case ActiveObject:
					setVariable(key, null);
					continue;
				case Boolean:
					setVariable(key, false);
					continue;
				case Direction:
					setVariable(key, IProgramFactory.Direction.RIGHT);
					continue;
				case Double:
					setVariable(key, 0.0);
					continue;
			}
		}
	}
}
