package jumpingalien.model.programs.statements.complex;

import jumpingalien.model.programs.Environment;
import jumpingalien.model.programs.Expression;
import jumpingalien.model.programs.Type;
import jumpingalien.part3.programs.SourceLocation;

/**
 * Created by covert on 16/08/15.
 */
public class AssignmentStatement extends ComplexStatement {
    String key;
    Type type;
    Expression value;
    public AssignmentStatement(SourceLocation sourceLocation, String variableName, Type variableType, Expression valueExpression) {
        super(sourceLocation);key = variableName;type = variableType;value = valueExpression;
    }

    public void exe(Environment env) {
        env.setVariable(key,value.getValue(env));
    }
}
