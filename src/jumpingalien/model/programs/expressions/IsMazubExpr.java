package jumpingalien.model.programs.expressions;

import jumpingalien.model.ActiveObject;
import jumpingalien.model.Mazub;
import jumpingalien.model.programs.Expression;
import jumpingalien.model.programs.expressions.data.BoolExpr;
import jumpingalien.model.programs.expressions.data.DoubleConstExpr;
import jumpingalien.model.programs.expressions.object.ObjectExpression;
import jumpingalien.part3.programs.SourceLocation;

/**
 * Created by covert on 14/08/15.
 */
public class IsMazubExpr extends Expression<BoolExpr> {
    Expression<ActiveObject> activeObject;
    public IsMazubExpr(SourceLocation sourceLocation,Expression<ActiveObject> obj) {
        super(sourceLocation);
        activeObject = obj;
    }

    @Override
    public BoolExpr getValue() {
        return new BoolExpr(getSourceLocation(),activeObject.getValue() instanceof Mazub);
    }
}
