package jumpingalien.model.programs.expressions;

import jumpingalien.model.Tile;
import jumpingalien.model.programs.Environment;
import jumpingalien.model.programs.Expression;
import jumpingalien.part3.programs.SourceLocation;

/**
 * Created by covert on 14/08/15.
 */
public class GetTileExpr extends Expression<Tile>
{
	Expression<Double> x, y;

	public GetTileExpr(SourceLocation source, Expression<Double> dx, Expression<Double> dy)
	{
		super(source);
		x = dx;
		y = dy;
	}

	public Tile getValue(Environment env)
	{
		return env.getwCaller().getTileinPixels(x.getValue(env).intValue(), y.getValue(env).intValue());
	}
}
