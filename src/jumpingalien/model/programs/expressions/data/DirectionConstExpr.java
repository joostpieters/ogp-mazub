package jumpingalien.model.programs.expressions.data;

import jumpingalien.part3.programs.IProgramFactory;
import jumpingalien.part3.programs.SourceLocation;

/**
 * Created by covert on 14/08/15.
 */
public class DirectionConstExpr extends DataExpression<IProgramFactory.Direction> {
    DirectionConstExpr(IProgramFactory.Direction direction) {
        super(direction);
    }
}
