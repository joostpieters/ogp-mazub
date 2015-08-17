package jumpingalien.model.programs;

import jumpingalien.model.ActiveObject;
import jumpingalien.model.Program;
import jumpingalien.model.World;
import jumpingalien.model.programs.statements.SequenceStatement;
import jumpingalien.part3.programs.IProgramFactory;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by covert on 14/08/15.
 */
public class Environment {
    private ActiveObject activeCaller;private Program programCaller;
    private HashMap<String, Object> allVariables = new HashMap<>();
    private Stack<Statement> statementStack = new Stack<>();
    private Stack<Integer> stackCounter = new Stack<>();

    public Environment(ActiveObject activeObject,Program program) {
        programCaller = program;
        activeCaller = activeObject;stackCounter.push(0);statementStack.push(program.getAllStatements());

        for (HashMap.Entry<String, Type> variable : program.getAllVars().entrySet()) {
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
                case ActiveObject:
                    setVariable(key,null);
                    continue;
            }
        }
    }

    public World getwCaller(){
        return activeCaller.getwCaller();
    }

    public ActiveObject getActiveCaller(){
        return activeCaller;
    }
    public Object getVariable(String key) {
        return allVariables.get(key);
    }

    public void setVariable(String name, Object value) {
        allVariables.put(name, value);
    }


    private int getLocalStatementCount() {
        Statement currentStatement = statementStack.peek();

        if (currentStatement instanceof SequenceStatement) {
            SequenceStatement block = (SequenceStatement) currentStatement;

            return block.getStatementList().size();
        } else {
            return 1;
        }
    }

    public void doStep() {

        int index = stackCounter.peek();

        if (stackCounter.peek() <= getLocalStatementCount() - 1) {//TODO refactor
            stackCounter.pop();
            stackCounter.push(index + 1);
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
//TODO
        if (currentStatement instanceof SequenceStatement) {
            SequenceStatement statement = (SequenceStatement) currentStatement;

            if (stackCounter.peek() >= statement.getStatementList().size()) {
                stepOut();
                return getStatement();
            }

            return statement.getStatementList().get(stackCounter.peek());
        } else {
            return statementStack.peek();
        }
    }

    private void reset() {
        stackCounter.clear();
        stackCounter.clear();
        allVariables.clear();
        statementStack.push(programCaller.getAllStatements());
        stackCounter.push(0);
        for (HashMap.Entry<String, Type> variable : programCaller.getAllVars().entrySet()) {
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
                case ActiveObject:
                    setVariable(key,null);
                    continue;
            }
        }
    }

    public void stepOut() {
        statementStack.pop();
        stackCounter.pop();
    }
}
