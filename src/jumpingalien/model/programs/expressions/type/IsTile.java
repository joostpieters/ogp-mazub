package jumpingalien.model.programs.expressions.type;

import jumpingalien.model.Tile;
import jumpingalien.model.programs.Expression;
import jumpingalien.part3.programs.SourceLocation;

public class IsTile extends TypeExpression
{
	public IsTile(SourceLocation sourceLocation, Expression obj)
	{
		super(sourceLocation, obj);
	}


	protected boolean exec(Object obj)
	{
		return obj instanceof Tile;
	}
}
