package jumpingalien.model.programs.expressions.data;

import jumpingalien.part3.programs.SourceLocation;

/**
 * Created by covert on 14/08/15.
 */
public class BoolExpr extends DataExpression<Boolean> {
    public BoolExpr(SourceLocation source, Boolean data) {
        super(source,data);
    }
}
