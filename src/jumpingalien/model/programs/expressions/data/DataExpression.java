package jumpingalien.model.programs.expressions.data;

import jumpingalien.model.programs.Expression;
import jumpingalien.part3.programs.SourceLocation;

/**
 * Created by covert on 14/08/15.
 */
public abstract class DataExpression<dataType> extends Expression{
    DataExpression(SourceLocation source, dataType data){
        super(source);dtValue = data;
    }

    private dataType dtValue;
    public dataType getValue(){
        return dtValue;
    }
}
