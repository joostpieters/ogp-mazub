package jumpingalien.model.programs.expressions.operator;

import jumpingalien.model.programs.Expression;
import jumpingalien.model.programs.expressions.data.DataExpression;
import jumpingalien.part3.programs.SourceLocation;

/**
 * Created by covert on 14/08/15.
 */
public abstract class operatorExpression extends Expression {
    private Expression expr1,expr2;
    public operatorExpression(SourceLocation source,Expression exprOne,Expression exprTwo) {
        super(source);
        expr1 = exprOne;expr2=exprTwo;
    }


    public abstract DataExpression getValue();
}
