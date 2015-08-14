package jumpingalien.model.programs;

import jumpingalien.part3.programs.SourceLocation;

/**
 * Created by covert on 14/08/15.
 */
public class Expression {
    SourceLocation sourceLocation;
    public Expression(SourceLocation source){
        sourceLocation = source;
    }

    public SourceLocation getSourceLocation(){
        return sourceLocation;
    }
}
