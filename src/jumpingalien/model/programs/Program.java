package jumpingalien.model.programs;

import java.util.Map;

public class Program {
    private Map<String, Type> globalVars;
    private Statement totalStatement;

    public Program(Map<String, Type> vars,Statement statements) {
        globalVars = vars;totalStatement = statements;
    }


    public Map<String, Type> getAllVars() {
        return globalVars;
    }

    public Statement getAllStatements() {
        return totalStatement;
    }

    public void nextStep(Environment environment) {
        environment.doStep();
    }
}
