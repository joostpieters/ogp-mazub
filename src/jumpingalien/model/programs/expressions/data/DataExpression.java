package jumpingalien.model.programs.expressions.data;

import jumpingalien.model.programs.Expression;
import jumpingalien.part3.programs.SourceLocation;

/**
 * Created by covert on 14/08/15.
 */
public abstract class DataExpression<dataType> implements Expression{
    DataExpression(dataType data){
        super();dtValue = data;
    }

    private dataType dtValue;
    public dataType getValue(){
        return dtValue;
    }
}
