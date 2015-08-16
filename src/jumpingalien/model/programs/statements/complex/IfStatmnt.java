package jumpingalien.model.programs.statements.complex;

import jumpingalien.model.programs.Environment;
import jumpingalien.model.programs.Expression;
import jumpingalien.model.programs.Statement;
import jumpingalien.part3.programs.SourceLocation;

/**
 * Created by covert on 16/08/15.
 */
public class IfStatmnt extends ConditionStatmnt {
    private Statement ifExpr,elseExpr;
    public IfStatmnt(SourceLocation sourceLocation, Expression<Boolean> conditionExpression
            , Statement ifBody, Statement elseBody) {
        super(sourceLocation, conditionExpression);
        ifExpr = ifBody;elseExpr = elseBody;
    }

    public void exe(Environment env) {
        if (testCondition(env)){
            ifExpr.exe(env);
        } else {
            if (elseExpr != null){
                elseExpr.exe(env);
            }
        }
    }
}
