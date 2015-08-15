package jumpingalien.model.programs;

import jumpingalien.model.ActiveObject;
import jumpingalien.part3.programs.IProgramFactory;
import jumpingalien.part3.programs.internal.generated.JumpingAlienProgParser;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by covert on 14/08/15.
 */
public class Environment {
    private Stack<Statement> originalStatement;private HashMap<String, Object> originalVariables = new HashMap<>();
    private ActiveObject activeCaller;private Program programCaller;
    private HashMap<String, Object> allVariables = new HashMap<>();
    private Stack<Statement> statementStack = new Stack<>();
    private Stack<Integer> stackCounter;

    public Environment(ActiveObject activeObject, HashMap<String, Type> variables, Statement mainStatement) {
        activeCaller = activeObject;

        for (HashMap.Entry<String, Type> variable : variables.entrySet()) {
            String key = variable.getKey(); Type type = variable.getValue();

            switch (type) {
                case Boolean:
                    setVariable(key,false);
                    continue;
                case Double:
                    setVariable(key,0.0);
                    continue;
                case Direction:
                    setVariable(key,IProgramFactory.Direction.UP);
                    continue;
                case Object:
                    setVariable(key,null);
                    continue;
            }
        }
        originalStatement = statementStack;originalVariables = allVariables;
    }


    public Object getVariable(String key) {
        return allVariables.get(key);
    }

    public void setVariable(String name, Object value) {
        allVariables.put(name, value);
    }


    private int getLocalStatementCount() {
        return statementStack.size();//TODO redo
    }

    public void doStep() {
        int index = stackCounter.peek();

        if (stackCounter.peek() < getLocalStatementCount() - 1) {
            stackCounter.push(stackCounter.pop() + 1);
        } else {
            stepOut();
        }
    }

    public void stepBack() {
        stackCounter.add(stackCounter.pop() + 1);
    }

    public void stepInto(Statement statement) {
        stackCounter.push(stackCounter.pop() + 1);

        statementStack.push(statement);
        stackCounter.push(-1);
    }

    public Statement getStatement() {
        assert (stackCounter.size() == statementStack.size());

        if (statementStack.isEmpty()) {
            reset();
        }

        Statement currentStatement = statementStack.peek();

        if (currentStatement instanceof StatementBlock) {
            StatementBlock block = (StatementBlock) currentStatement;

            if (statementIndices.peek() >= block.getStatements().size()) {
                stepOut();
                return getStatement();
            }

            return block.getStatements().get(statementIndices.peek());
        } else {
            return statementStack.peek();
        }
    }

    private void reset() {
        statementStack = originalStatement;allVariables = originalVariables;
    }

    public void stepOut() {
        statementStack.pop();
        stackCounter.pop();
    }
}
