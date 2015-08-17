package jumpingalien.model.programs.statements.complex;

import jumpingalien.model.programs.Environment;
import jumpingalien.model.programs.Expression;
import jumpingalien.model.programs.Statement;
import jumpingalien.part3.programs.IProgramFactory;
import jumpingalien.part3.programs.SourceLocation;

public class ForEachStatmnt extends ConditionStatmnt
{
	private final String key;
	private final Expression sortExpression;
	private final IProgramFactory.SortDirection sortDirection;
	private final IProgramFactory.Kind kind;
	private final Statement bodyStatement;

	public ForEachStatmnt(SourceLocation sourceLocation, String name, IProgramFactory.Kind variableKind, Expression where, Expression sort
			, IProgramFactory.SortDirection sortDir, Statement body)
	{
		super(sourceLocation, where);
		key = name;
		kind = variableKind;
		sortExpression = sort;
		sortDirection = sortDir;
		bodyStatement = body;
	}

	public void exe(Environment env)
	{
		//TODO
	}
}
