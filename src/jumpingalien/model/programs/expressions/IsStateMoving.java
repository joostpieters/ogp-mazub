package jumpingalien.model.programs.expressions;

import jumpingalien.model.ActiveObject;
import jumpingalien.model.programs.Environment;
import jumpingalien.model.programs.Expression;
import jumpingalien.part3.programs.IProgramFactory;
import jumpingalien.part3.programs.SourceLocation;

/**
 * Created by covert on 16/08/15.
 */
public class IsStateMoving extends Expression<Boolean> {
    Expression<IProgramFactory.Direction> di;
    Expression<ActiveObject> obj;
    public IsStateMoving(SourceLocation sourceLocation, Expression<ActiveObject> activeObjectExpression, Expression<IProgramFactory.Direction> direction) {
        super(sourceLocation);
        di = direction;obj = activeObjectExpression;
    }
    @Override
    public Boolean getValue(Environment en){
        assert obj.getValue(en) instanceof ActiveObject;
        ActiveObject activeObject = (ActiveObject) obj.getValue(en);
        return exec(obj,en);
    }

    private boolean exec(Object obj,Environment en) {
        assert obj instanceof ActiveObject;
        ActiveObject activeObject = (ActiveObject) obj;
        return checkState(activeObject,en);
    }

    private boolean checkState(ActiveObject activeObject,Environment en) {
        switch (di.getValue(en)){

            case LEFT:
                return (activeObject.getVelocity()[0] < 0);
            case RIGHT:
                return (activeObject.getVelocity()[0] > 0);
            case UP:
                return (activeObject.getVelocity()[1] > 0);
            case DOWN:
                return (activeObject.getVelocity()[1] < 0);
            default:
                return false;
        }
    }
}
