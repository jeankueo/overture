package org.overture.typechecker.assistant.pattern;

import java.util.List;

import org.overture.ast.analysis.intf.IQuestionAnswer;
import org.overture.ast.definitions.PDefinition;
import org.overture.ast.patterns.APatternTypePair;
import org.overture.ast.typechecker.NameScope;
import org.overture.ast.types.PType;
import org.overture.typechecker.TypeCheckInfo;
import org.overture.typechecker.assistant.ITypeCheckerAssistantFactory;

public class APatternTypePairAssistant
{
	protected ITypeCheckerAssistantFactory af;

	public APatternTypePairAssistant(ITypeCheckerAssistantFactory af)
	{
		this.af = af;
	}

	public List<PDefinition> getDefinitions(APatternTypePair result)
	{

		return af.createPPatternAssistant().getDefinitions(result.getPattern(), result.getType(), NameScope.LOCAL);
	}

	public void typeResolve(APatternTypePair result,
			IQuestionAnswer<TypeCheckInfo, PType> rootVisitor,
			TypeCheckInfo question)
	{

		if (result.getResolved())
		{
			return;
		} else
		{
			result.setResolved(true);
		}
		result.setType(af.createPTypeAssistant().typeResolve(result.getType(), null, rootVisitor, question));

	}

}
