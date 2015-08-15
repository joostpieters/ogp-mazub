package jumpingalien.model.programs.expressions.object;

import jumpingalien.model.ActiveObject;
import jumpingalien.model.programs.Environment;
import jumpingalien.model.programs.Expression;
import jumpingalien.model.programs.expressions.data.DoubleConstExpr;
import jumpingalien.part3.programs.SourceLocation;

/**
 * Created by covert on 14/08/15.
 */
public abstract class ObjectExpression extends Expression<DoubleConstExpr> {
    Expression<ActiveObject> activeObject;
    public ObjectExpression(SourceLocation sourceLocation,Expression<ActiveObject> obj) {
        super(sourceLocation);
        activeObject = obj;
    }

    protected abstract double exec(ActiveObject activeObject);


    public DoubleConstExpr getValue(Environment env){
        return new DoubleConstExpr(getSourceLocation(),exec(activeObject.getValue(env)));
    };
}
