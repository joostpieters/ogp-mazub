package jumpingalien.model.programs.expressions.type;

import jumpingalien.model.Tile;
import jumpingalien.model.programs.Expression;
import jumpingalien.part3.programs.SourceLocation;

/**
 * Created by covert on 16/08/15.
 */
public class IsTileType extends TypeExpression {
    int type;
    public IsTileType(SourceLocation sourceLocation, Expression obj,int geotype) {
        super(sourceLocation, obj);
        type = geotype;
    }

    protected boolean exec(Object obj) {
        assert obj instanceof Tile;
        Tile tile = (Tile) obj;
        return (tile.getGeoFeature() != type);
    }
}
