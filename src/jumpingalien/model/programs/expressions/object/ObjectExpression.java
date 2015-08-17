package jumpingalien.model.programs.expressions.object;

import jumpingalien.model.ActiveObject;
import jumpingalien.model.programs.Environment;
import jumpingalien.model.programs.Expression;
import jumpingalien.part3.programs.SourceLocation;

/**
 * Created by covert on 14/08/15.
 */
public abstract class ObjectExpression extends Expression<Double> {
    Expression<ActiveObject> activeObject;
    public ObjectExpression(SourceLocation sourceLocation,Expression<ActiveObject> obj) {
        super(sourceLocation);
        activeObject = obj;
    }

    protected abstract double exec(ActiveObject activeObject);


    public Double getValue(Environment env){
        return exec(activeObject.getValue(env));
    };
}
