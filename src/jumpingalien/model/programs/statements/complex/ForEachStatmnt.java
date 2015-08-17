package jumpingalien.model.programs.statements.complex;

import jumpingalien.model.programs.Environment;
import jumpingalien.model.programs.Expression;
import jumpingalien.model.programs.Statement;
import jumpingalien.part3.programs.IProgramFactory;
import jumpingalien.part3.programs.SourceLocation;

/**
 * Created by covert on 16/08/15.
 */
public class ForEachStatmnt extends ConditionStatmnt
{
	private String key;
	private Expression whereExpression, sortExpression;
	private IProgramFactory.SortDirection sortDirection;
	private IProgramFactory.Kind kind;
	private Statement bodyStatement;

	public ForEachStatmnt(SourceLocation sourceLocation, String name, IProgramFactory.Kind variableKind, Expression where, Expression sort
			, IProgramFactory.SortDirection sortDir, Statement body)
	{
		super(sourceLocation, null);
		key = name;
		kind = variableKind;
		whereExpression = where;
		sortExpression = sort;
		sortDirection = sortDir;
		bodyStatement = body;
	}

	public void exe(Environment env)
	{
		//TODO
	}
}
