package jumpingalien.model.programs.expressions;

import jumpingalien.model.programs.Environment;
import jumpingalien.model.programs.Expression;
import jumpingalien.model.programs.Type;
import jumpingalien.model.programs.expressions.data.DataExpression;
import jumpingalien.part3.programs.SourceLocation;

/**
 * Created by covert on 14/08/15.
 */
public class ReadVarExpr<DataType> extends Expression<DataType>{
    private String key;
    public ReadVarExpr(SourceLocation sourceLocation,String ky){
        super(sourceLocation);
        key = ky;
    }


    public DataType getValue(Environment env) {
        return (DataType) env.getVariable(key);
    }
}
