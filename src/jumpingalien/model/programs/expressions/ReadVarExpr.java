package jumpingalien.model.programs.expressions;

import jumpingalien.model.programs.Environment;
import jumpingalien.model.programs.Expression;
import jumpingalien.part3.programs.SourceLocation;

/**
 * Created by covert on 14/08/15.
 */
public class ReadVarExpr<dataType> extends Expression<dataType>{
    private String key;
    public ReadVarExpr(SourceLocation sourceLocation,String ky){
        super(sourceLocation);
        key = ky;
    }


    public dataType getValue(Environment env) {
        return (dataType) env.getVariable(key);
    }
}
