package jumpingalien.model.programs.expressions.object;

import jumpingalien.model.ActiveObject;
import jumpingalien.model.programs.Expression;
import jumpingalien.model.programs.expressions.data.DoubleConstExpr;
import jumpingalien.part3.programs.SourceLocation;

/**
 * Created by covert on 14/08/15.
 */
public class GetHitPointsExpr extends ObjectExpression {
    public GetHitPointsExpr(SourceLocation sourceLocation, Expression<ActiveObject> obj) {
        super(sourceLocation, obj);
    }

    protected double exec(ActiveObject activeObject) {
        return activeObject.getHealth();
    }
}

