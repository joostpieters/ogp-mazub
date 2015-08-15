package jumpingalien.model.programs.expressions.object;

import jumpingalien.model.ActiveObject;
import jumpingalien.model.programs.Expression;
import jumpingalien.model.programs.expressions.data.DoubleConstExpr;
import jumpingalien.part3.programs.SourceLocation;

/**
 * Created by covert on 14/08/15.
 */
public class GetYExpr extends ObjectExpression {
    public GetYExpr(SourceLocation sourceLocation, Expression<ActiveObject> obj) {
        super(sourceLocation, obj);
    }


    public double exec(ActiveObject activeObject) {
        return activeObject.getRawLocation()[1];
    }
}
