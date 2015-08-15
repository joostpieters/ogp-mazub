package jumpingalien.model.programs.expressions.data;

import jumpingalien.model.Tile;
import jumpingalien.model.World;
import jumpingalien.model.programs.Expression;
import jumpingalien.part3.programs.SourceLocation;

/**
 * Created by covert on 14/08/15.
 */
public class GetTileExpr extends DataExpression<Tile> {
    GetTileExpr(SourceLocation source, Expression<Double> x, Expression<Double> y,World world) {
        super(source, world.getTileinPixels( x.getValue().intValue(),y.getValue().intValue()));
    }
}
