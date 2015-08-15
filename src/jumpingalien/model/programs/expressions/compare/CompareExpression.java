package jumpingalien.model.programs.expressions.compare;

import com.sun.org.apache.xpath.internal.operations.Bool;
import jumpingalien.model.programs.Expression;
import jumpingalien.model.programs.expressions.data.BoolExpr;
import jumpingalien.model.programs.expressions.data.DataExpression;
import jumpingalien.model.programs.expressions.operator.OperatorExpression;
import jumpingalien.part3.programs.SourceLocation;

import java.util.Comparator;

/**
 * Created by covert on 14/08/15.
 */
public abstract class CompareExpression extends Expression<BoolExpr>{
    private Expression<Boolean> exprOne,exprTwo;
    public CompareExpression(SourceLocation source, Expression<Boolean> expr1, Expression<Boolean> expr2) {
        super(source);
        exprOne = expr1;exprTwo = expr2;
    }

    public abstract Boolean exec(boolean bool1 , boolean bool2);

    public BoolExpr getValue(){
        return new BoolExpr(getSourceLocation(),exec(exprOne.getValue(), exprOne.getValue()));
    }
}
