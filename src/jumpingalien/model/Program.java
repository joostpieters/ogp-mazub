package jumpingalien.model;

import jumpingalien.model.programs.Environment;
import jumpingalien.model.programs.Statement;
import jumpingalien.model.programs.Type;

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