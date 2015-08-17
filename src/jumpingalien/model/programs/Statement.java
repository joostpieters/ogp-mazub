package jumpingalien.model.programs;

import jumpingalien.part3.programs.SourceLocation;

/**
 * Created by covert on 14/08/15.
 */
public abstract class Statement {
    private final SourceLocation sourceLocation;

    public Statement(SourceLocation sourceLocation) {
        this.sourceLocation = sourceLocation;
    }
    public SourceLocation getSourceLocation(){
        return sourceLocation;
    }
    public abstract void exe(Environment env);
}
