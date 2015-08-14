package jumpingalien.model.programs.expressions;

import jumpingalien.model.programs.expressions.data.DataExpression;
import jumpingalien.model.programs.expressions.recursive.RecursiveExpression;
import jumpingalien.part3.programs.SourceLocation;

/**
 * Created by covert on 14/08/15.
 */
public class SelfExpr extends RecursiveExpression {
    public SelfExpr(SourceLocation source) {
        super(source);
    }

    public DataExpression getValue() {

    }
}
