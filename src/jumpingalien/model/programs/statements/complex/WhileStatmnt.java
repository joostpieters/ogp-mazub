package jumpingalien.model.programs.statements.complex;

import jumpingalien.model.programs.Environment;
import jumpingalien.model.programs.Expression;
import jumpingalien.model.programs.Statement;
import jumpingalien.part3.programs.SourceLocation;

/**
 * Created by covert on 16/08/15.
 */
public class WhileStatmnt extends ConditionStatmnt {
    Statement whileBody;
    public WhileStatmnt(SourceLocation sourceLocation, Expression<Boolean> conditionExpression,Statement body) {
        super(sourceLocation, conditionExpression);
        whileBody = body;
    }

    public void exe(Environment env) {
        if (testCondition(env)){
            whileBody.exe(env);
        }
    }
}
