package jumpingalien.model.programs.expressions.data;

import jumpingalien.model.programs.Environment;
import jumpingalien.model.programs.Expression;
import jumpingalien.part3.programs.SourceLocation;

public abstract class DataExpression<dataType> extends Expression<dataType>
{
	private final dataType dtValue;

	DataExpression(SourceLocation source, dataType data)
	{
		super(source);
		dtValue = data;
	}

	public dataType getValue(Environment env)
	{
		return dtValue;
	}
}
