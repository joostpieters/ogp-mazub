package jumpingalien.model.programs.expressions.logical;

import jumpingalien.model.programs.Environment;
import jumpingalien.model.programs.Expression;
import jumpingalien.model.programs.expressions.data.BoolExpr;
import jumpingalien.part3.programs.SourceLocation;

/**
 * Created by covert on 14/08/15.
 */
public class NotExpr extends Expression<BoolExpr> {
    //TODO !!!
    //TODO met anonymouse class
    //TODO !!!
    Expression<Boolean> exprOne;
    public NotExpr(SourceLocation source, Expression<Boolean> expr1) {
        super(source);
        exprOne = expr1;
    }

    public BoolExpr getValue(Environment env) {
        return new BoolExpr(getSourceLocation(),!exprOne.getValue(env));
    }
}
