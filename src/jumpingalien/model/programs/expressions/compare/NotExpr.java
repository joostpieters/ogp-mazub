package jumpingalien.model.programs.expressions.compare;

import com.sun.org.apache.xpath.internal.operations.Bool;
import jumpingalien.model.programs.Expression;
import jumpingalien.model.programs.expressions.data.BoolExpr;
import jumpingalien.part3.programs.SourceLocation;

/**
 * Created by covert on 14/08/15.
 */
public class NotExpr extends Expression<BoolExpr> {
    Expression<Boolean> exprOne;
    public NotExpr(SourceLocation source, Expression<Boolean> expr1) {
        super(source);
        exprOne = expr1;
    }

    @Override
    public BoolExpr getValue() {
        return new BoolExpr(getSourceLocation(),!exprOne.getValue());
    }
}
