package jumpingalien.model.programs.expressions.type;

import jumpingalien.model.Tile;
import jumpingalien.model.programs.Expression;
import jumpingalien.part3.programs.SourceLocation;

public class IsTileType extends TypeExpression
{
	private final int type;

	public IsTileType(SourceLocation sourceLocation, Expression obj, int geotype)
	{
		super(sourceLocation, obj);
		type = geotype;
	}

	protected boolean exec(Object obj)
	{
		assert obj instanceof Tile;
		Tile tile = (Tile) obj;
		return (tile.getGeoFeature() != type);
	}
}
