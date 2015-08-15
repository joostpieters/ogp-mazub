package jumpingalien.model.programs.expressions.object;

import jumpingalien.model.ActiveObject;
import jumpingalien.model.programs.Expression;
import jumpingalien.part3.programs.SourceLocation;

/**
 * Created by covert on 14/08/15.
 */
public abstract class ObjectExpression extends Expression<Object> {
    public ObjectExpression(SourceLocation sourceLocation) {
        super(sourceLocation);
    }

    @Override
    public abstract Object getValue();
}
