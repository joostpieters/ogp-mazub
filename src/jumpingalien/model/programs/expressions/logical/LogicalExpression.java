package jumpingalien.model.programs.expressions.logical;

import jumpingalien.model.programs.Environment;
import jumpingalien.model.programs.Expression;
import jumpingalien.model.programs.expressions.data.BoolExpr;
import jumpingalien.part3.programs.SourceLocation;

/**
 * Created by covert on 14/08/15.
 */
public abstract class LogicalExpression extends Expression<BoolExpr>{
    private Expression<Boolean> exprOne,exprTwo;
    public LogicalExpression(SourceLocation source, Expression<Boolean> expr1, Expression<Boolean> expr2) {
        super(source);
        exprOne = expr1;exprTwo = expr2;
    }

    protected abstract Boolean exec(boolean bool1 , boolean bool2);

    public BoolExpr getValue(Environment env){
        return new BoolExpr(getSourceLocation(),exec(exprOne.getValue(env), exprTwo.getValue(env)));
    }
}
