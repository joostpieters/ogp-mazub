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
    private ActiveObject activeCaller;
    private Map<String, Object> allVariables = new HashMap<>();
    private Stack<Statement> statementStack = new Stack<>();
    private Statement originalStatement;private Map<String, Type> originalVariables = new HashMap<>();

    public Environment(ActiveObject activeObject, Map<String, Type> variables, Statement mainStatement) {
        activeCaller = activeObject;originalStatement = mainStatement;originalVariables = variables;

        for (Map.Entry<String, Type> variable : variables.entrySet()) {
            String key = variable.getKey(); Type type = variable.getValue(); Object obj;

            switch (type) {
                case Boolean:
                    obj = false;
                    break;
                case Direction:
                    obj = IProgramFactory.Direction.UP;
                    break;
                case Double:
                    obj = 0.0;
                    break;
                case Object:
                default:
                    throw new InvalidParameterException("Unexpected type");
            }
            setVariable(key, obj);
        }
    }


    public Object getVariable(String key) {
        return allVariables.get(key);
    }

    public void setVariable(String name, Object value) {
        allVariables.put(name, value);
    }


    private int getLocalStatementCount() {
        Statement currentStatement = statementStack.peek();

        if (currentStatement instanceof StatementBlock) {
            StatementBlock block = (StatementBlock) currentStatement;

            return block.getStatements().size();
        } else {
            return 1;
        }
    }

    public void doStep() {
        int index = statementIndices.peek();

        if (index < getLocalStatementCount() - 1) {
            statementIndices.pop();
            statementIndices.push(index + 1);
        } else {
            stepOut();
        }
    }

    public void stepBack() {
        statementIndices.push(statementIndices.pop() - 1);
    }

    public void stepInto(Statement body) {
        statementIndices.push(statementIndices.pop() + 1);

        statementStack.push(body);
        statementIndices.push(-1);
    }

    public Statement getStatement() {
        assert (statementIndices.size() == statementStack.size());

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

    private Environment reset() {
        return new Environment(activeCaller,originalVariables,originalStatement);
    }

    public void stepOut() {
        statementStack.pop();
        statementIndices.pop();
    }
}
