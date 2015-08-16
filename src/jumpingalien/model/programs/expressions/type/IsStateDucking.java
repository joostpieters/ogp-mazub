package jumpingalien.model.programs.expressions.type;

import jumpingalien.model.ActiveObject;
import jumpingalien.model.programs.Expression;
import jumpingalien.part3.programs.SourceLocation;

/**
 * Created by covert on 16/08/15.
 */
public class IsStateDucking extends IsState {
    public IsStateDucking(SourceLocation sourceLocation, Expression obj) {
        super(sourceLocation, obj);
    }


    protected boolean checkState(ActiveObject activeObject) {
        return (activeObject.isDucking());
    }
}
