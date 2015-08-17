package jumpingalien.model.programs.expressions.recursive;

import jumpingalien.model.programs.Environment;
import jumpingalien.model.programs.Expression;
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

    public Double getValue(Environment en) {
        return random.nextInt(getInternalExpression().getValue(en).intValue()) - 1 + random.nextDouble();
    }
}
