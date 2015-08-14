package jumpingalien.model.programs.expressions.recursive;

import jumpingalien.model.programs.Expression;
import jumpingalien.model.programs.expressions.data.DataExpression;
import jumpingalien.model.programs.expressions.data.DoubleConstExpr;
import jumpingalien.part3.programs.SourceLocation;

import java.util.Random;

/**
 * Created by covert on 14/08/15.
 */
public class RandomExpr extends RecursiveExpression {
    Random random = new Random();
    public RandomExpr(SourceLocation source, Expression<Double> expression) {
        super(source, expression);

    }

    @Override
    public DataExpression getValue() {
        return new DoubleConstExpr( random.nextDouble() * (double) getInternalExpression().getValue());
    }
}
