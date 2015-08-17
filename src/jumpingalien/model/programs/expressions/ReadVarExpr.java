package jumpingalien.model.programs.expressions;

import jumpingalien.model.programs.Environment;
import jumpingalien.model.programs.Expression;
import jumpingalien.part3.programs.SourceLocation;

public class ReadVarExpr<dataType> extends Expression<dataType>
{
	private final String key;

	public ReadVarExpr(SourceLocation sourceLocation, String ky)
	{
		super(sourceLocation);
		key = ky;
	}


	public dataType getValue(Environment env)
	{
		return (dataType) env.getVariable(key);
	}
}
