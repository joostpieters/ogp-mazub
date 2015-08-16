package jumpingalien.model.programs.expressions.type;

import jumpingalien.model.ActiveObject;
import jumpingalien.model.Buzam;
import jumpingalien.model.Mazub;
import jumpingalien.model.programs.Expression;
import jumpingalien.part3.programs.SourceLocation;

/**
 * Created by covert on 15/08/15.
 */
public class IsMazubExpr extends TypeExpression {

    public IsMazubExpr(SourceLocation sourceLocation, Expression<ActiveObject> obj) {
        super(sourceLocation, obj);
    }

    protected boolean exec(Object obj) {
        return obj instanceof Mazub && !(obj instanceof Buzam);
    }
}
