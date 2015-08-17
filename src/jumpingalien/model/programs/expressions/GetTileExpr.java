package jumpingalien.model.programs.expressions;

import jumpingalien.model.Tile;
import jumpingalien.model.programs.Environment;
import jumpingalien.model.programs.Expression;
import jumpingalien.part3.programs.SourceLocation;

public class GetTileExpr extends Expression<Tile>
{
	private final Expression<Double> x;
	private final Expression<Double> y;

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
