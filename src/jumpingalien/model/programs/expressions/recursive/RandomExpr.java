package jumpingalien.model.programs.expressions.recursive;

import jumpingalien.model.programs.Expression;
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
    public DoubleConstExpr getValue() {
        return new DoubleConstExpr(getSourceLocation(),
                random.nextInt((int) getInternalExpression().getValue()) - 1 + random.nextDouble());
    }
}
