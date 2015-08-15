package jumpingalien.model.programs;

import java.util.HashMap;
import java.util.Map;

public class Program {
    private HashMap<String, Type> globalVars;
    private Statement totalStatement;

    public Program(HashMap<String, Type> vars,Statement statements) {
        globalVars = vars;totalStatement = statements;
    }


    public Statement getAllStatements() {
        return totalStatement;
    }

    public HashMap<String, Type> getAllVars() {
        return globalVars;
    }

    public void doStep(Environment environment) {
        environment.doStep();
    }
}
