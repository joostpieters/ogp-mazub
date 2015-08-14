package jumpingalien.model.programs.expressions.dataExpression;

import jumpingalien.model.programs.Expression;
import jumpingalien.part3.programs.SourceLocation;

/**
 * Created by covert on 14/08/15.
 */
public abstract class dataExpression<dataType> extends Expression{
    dataExpression(SourceLocation source){
        super(source);
    }

    private dataType dtValue;
    public dataType getValue(){
        return dtValue;
    }
}
