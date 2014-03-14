package org.overture.codegen.visitor;

import java.util.LinkedList;

import org.overture.ast.analysis.AnalysisException;
import org.overture.ast.definitions.AAssignmentDefinition;
import org.overture.ast.definitions.AInstanceVariableDefinition;
import org.overture.ast.definitions.ALocalDefinition;
import org.overture.ast.definitions.PDefinition;
import org.overture.ast.definitions.SClassDefinition;
import org.overture.ast.expressions.AAbsoluteUnaryExp;
import org.overture.ast.expressions.AAndBooleanBinaryExp;
import org.overture.ast.expressions.AApplyExp;
import org.overture.ast.expressions.ABooleanConstExp;
import org.overture.ast.expressions.ACardinalityUnaryExp;
import org.overture.ast.expressions.ACharLiteralExp;
import org.overture.ast.expressions.ADistConcatUnaryExp;
import org.overture.ast.expressions.ADistIntersectUnaryExp;
import org.overture.ast.expressions.ADistMergeUnaryExp;
import org.overture.ast.expressions.ADistUnionUnaryExp;
import org.overture.ast.expressions.ADivNumericBinaryExp;
import org.overture.ast.expressions.ADivideNumericBinaryExp;
import org.overture.ast.expressions.ADomainResByBinaryExp;
import org.overture.ast.expressions.ADomainResToBinaryExp;
import org.overture.ast.expressions.AElementsUnaryExp;
import org.overture.ast.expressions.AElseIfExp;
import org.overture.ast.expressions.AEqualsBinaryExp;
import org.overture.ast.expressions.AEquivalentBooleanBinaryExp;
import org.overture.ast.expressions.AFieldExp;
import org.overture.ast.expressions.AFieldNumberExp;
import org.overture.ast.expressions.AFloorUnaryExp;
import org.overture.ast.expressions.AForAllExp;
import org.overture.ast.expressions.AFuncInstatiationExp;
import org.overture.ast.expressions.AGreaterEqualNumericBinaryExp;
import org.overture.ast.expressions.AGreaterNumericBinaryExp;
import org.overture.ast.expressions.AHeadUnaryExp;
import org.overture.ast.expressions.AIfExp;
import org.overture.ast.expressions.AImpliesBooleanBinaryExp;
import org.overture.ast.expressions.AInSetBinaryExp;
import org.overture.ast.expressions.AIndicesUnaryExp;
import org.overture.ast.expressions.AIntLiteralExp;
import org.overture.ast.expressions.AIsOfClassExp;
import org.overture.ast.expressions.ALenUnaryExp;
import org.overture.ast.expressions.ALessEqualNumericBinaryExp;
import org.overture.ast.expressions.ALessNumericBinaryExp;
import org.overture.ast.expressions.ALetBeStExp;
import org.overture.ast.expressions.ALetDefExp;
import org.overture.ast.expressions.AMapCompMapExp;
import org.overture.ast.expressions.AMapDomainUnaryExp;
import org.overture.ast.expressions.AMapEnumMapExp;
import org.overture.ast.expressions.AMapInverseUnaryExp;
import org.overture.ast.expressions.AMapRangeUnaryExp;
import org.overture.ast.expressions.AMapUnionBinaryExp;
import org.overture.ast.expressions.AMapletExp;
import org.overture.ast.expressions.AMkBasicExp;
import org.overture.ast.expressions.AMkTypeExp;
import org.overture.ast.expressions.AModNumericBinaryExp;
import org.overture.ast.expressions.ANewExp;
import org.overture.ast.expressions.ANilExp;
import org.overture.ast.expressions.ANotEqualBinaryExp;
import org.overture.ast.expressions.ANotInSetBinaryExp;
import org.overture.ast.expressions.ANotUnaryExp;
import org.overture.ast.expressions.AOrBooleanBinaryExp;
import org.overture.ast.expressions.APlusNumericBinaryExp;
import org.overture.ast.expressions.APlusPlusBinaryExp;
import org.overture.ast.expressions.APowerSetUnaryExp;
import org.overture.ast.expressions.AProperSubsetBinaryExp;
import org.overture.ast.expressions.AQuoteLiteralExp;
import org.overture.ast.expressions.ARangeResByBinaryExp;
import org.overture.ast.expressions.ARangeResToBinaryExp;
import org.overture.ast.expressions.ARealLiteralExp;
import org.overture.ast.expressions.ARemNumericBinaryExp;
import org.overture.ast.expressions.AReverseUnaryExp;
import org.overture.ast.expressions.ASelfExp;
import org.overture.ast.expressions.ASeqCompSeqExp;
import org.overture.ast.expressions.ASeqConcatBinaryExp;
import org.overture.ast.expressions.ASeqEnumSeqExp;
import org.overture.ast.expressions.ASetCompSetExp;
import org.overture.ast.expressions.ASetDifferenceBinaryExp;
import org.overture.ast.expressions.ASetEnumSetExp;
import org.overture.ast.expressions.ASetIntersectBinaryExp;
import org.overture.ast.expressions.ASetRangeSetExp;
import org.overture.ast.expressions.ASetUnionBinaryExp;
import org.overture.ast.expressions.AStarStarBinaryExp;
import org.overture.ast.expressions.AStringLiteralExp;
import org.overture.ast.expressions.ASubclassResponsibilityExp;
import org.overture.ast.expressions.ASubsetBinaryExp;
import org.overture.ast.expressions.ASubtractNumericBinaryExp;
import org.overture.ast.expressions.ATailUnaryExp;
import org.overture.ast.expressions.ATimesNumericBinaryExp;
import org.overture.ast.expressions.ATupleExp;
import org.overture.ast.expressions.AUnaryMinusUnaryExp;
import org.overture.ast.expressions.AUnaryPlusUnaryExp;
import org.overture.ast.expressions.AVariableExp;
import org.overture.ast.expressions.PExp;
import org.overture.ast.expressions.SBinaryExp;
import org.overture.ast.patterns.AIdentifierPattern;
import org.overture.ast.patterns.ASetMultipleBind;
import org.overture.ast.patterns.PMultipleBind;
import org.overture.ast.patterns.PPattern;
import org.overture.ast.types.AClassType;
import org.overture.ast.types.ARecordInvariantType;
import org.overture.ast.types.ASetType;
import org.overture.ast.types.ATokenBasicType;
import org.overture.ast.types.PType;
import org.overture.ast.types.SMapType;
import org.overture.ast.types.SSeqType;
import org.overture.codegen.cgast.expressions.AAbsUnaryExpCG;
import org.overture.codegen.cgast.expressions.AAndBoolBinaryExpCG;
import org.overture.codegen.cgast.expressions.AApplyExpCG;
import org.overture.codegen.cgast.expressions.ACompMapExpCG;
import org.overture.codegen.cgast.expressions.ACompSeqExpCG;
import org.overture.codegen.cgast.expressions.ACompSetExpCG;
import org.overture.codegen.cgast.expressions.ADistConcatUnaryExpCG;
import org.overture.codegen.cgast.expressions.ADistIntersectUnaryExpCG;
import org.overture.codegen.cgast.expressions.ADistMergeUnaryExpCG;
import org.overture.codegen.cgast.expressions.ADistUnionUnaryExpCG;
import org.overture.codegen.cgast.expressions.ADivideNumericBinaryExpCG;
import org.overture.codegen.cgast.expressions.ADomainResByBinaryExpCG;
import org.overture.codegen.cgast.expressions.ADomainResToBinaryExpCG;
import org.overture.codegen.cgast.expressions.AElemsUnaryExpCG;
import org.overture.codegen.cgast.expressions.AEnumMapExpCG;
import org.overture.codegen.cgast.expressions.AEnumSeqExpCG;
import org.overture.codegen.cgast.expressions.AEnumSetExpCG;
import org.overture.codegen.cgast.expressions.AEqualsBinaryExpCG;
import org.overture.codegen.cgast.expressions.AExplicitVariableExpCG;
import org.overture.codegen.cgast.expressions.AFieldExpCG;
import org.overture.codegen.cgast.expressions.AFieldNumberExpCG;
import org.overture.codegen.cgast.expressions.AFloorUnaryExpCG;
import org.overture.codegen.cgast.expressions.AForAllExpCG;
import org.overture.codegen.cgast.expressions.AGreaterEqualNumericBinaryExpCG;
import org.overture.codegen.cgast.expressions.AGreaterNumericBinaryExpCG;
import org.overture.codegen.cgast.expressions.AHeadUnaryExpCG;
import org.overture.codegen.cgast.expressions.AInSetBinaryExpCG;
import org.overture.codegen.cgast.expressions.AIndicesUnaryExpCG;
import org.overture.codegen.cgast.expressions.AInstanceofExpCG;
import org.overture.codegen.cgast.expressions.ALessEqualNumericBinaryExpCG;
import org.overture.codegen.cgast.expressions.ALessNumericBinaryExpCG;
import org.overture.codegen.cgast.expressions.ALetBeStExpCG;
import org.overture.codegen.cgast.expressions.ALetDefExpCG;
import org.overture.codegen.cgast.expressions.AMapDomainUnaryExpCG;
import org.overture.codegen.cgast.expressions.AMapInverseUnaryExpCG;
import org.overture.codegen.cgast.expressions.AMapOverrideBinaryExpCG;
import org.overture.codegen.cgast.expressions.AMapRangeUnaryExpCG;
import org.overture.codegen.cgast.expressions.AMapUnionBinaryExpCG;
import org.overture.codegen.cgast.expressions.AMapletExpCG;
import org.overture.codegen.cgast.expressions.AMethodInstantiationExpCG;
import org.overture.codegen.cgast.expressions.AMinusUnaryExpCG;
import org.overture.codegen.cgast.expressions.AMkBasicExpCG;
import org.overture.codegen.cgast.expressions.ANewExpCG;
import org.overture.codegen.cgast.expressions.ANotEqualsBinaryExpCG;
import org.overture.codegen.cgast.expressions.ANotUnaryExpCG;
import org.overture.codegen.cgast.expressions.ANullExpCG;
import org.overture.codegen.cgast.expressions.AOrBoolBinaryExpCG;
import org.overture.codegen.cgast.expressions.APlusNumericBinaryExpCG;
import org.overture.codegen.cgast.expressions.APlusUnaryExpCG;
import org.overture.codegen.cgast.expressions.APowerNumericBinaryExpCG;
import org.overture.codegen.cgast.expressions.APowerSetUnaryExpCG;
import org.overture.codegen.cgast.expressions.AQuoteLiteralExpCG;
import org.overture.codegen.cgast.expressions.ARangeResByBinaryExpCG;
import org.overture.codegen.cgast.expressions.ARangeResToBinaryExpCG;
import org.overture.codegen.cgast.expressions.ARangeSetExpCG;
import org.overture.codegen.cgast.expressions.ARealLiteralExpCG;
import org.overture.codegen.cgast.expressions.AReverseUnaryExpCG;
import org.overture.codegen.cgast.expressions.ASelfExpCG;
import org.overture.codegen.cgast.expressions.ASeqConcatBinaryExpCG;
import org.overture.codegen.cgast.expressions.ASeqModificationBinaryExpCG;
import org.overture.codegen.cgast.expressions.ASetDifferenceBinaryExpCG;
import org.overture.codegen.cgast.expressions.ASetIntersectBinaryExpCG;
import org.overture.codegen.cgast.expressions.ASetProperSubsetBinaryExpCG;
import org.overture.codegen.cgast.expressions.ASetSubsetBinaryExpCG;
import org.overture.codegen.cgast.expressions.ASetUnionBinaryExpCG;
import org.overture.codegen.cgast.expressions.ASizeUnaryExpCG;
import org.overture.codegen.cgast.expressions.ASubtractNumericBinaryExpCG;
import org.overture.codegen.cgast.expressions.ATailUnaryExpCG;
import org.overture.codegen.cgast.expressions.ATernaryIfExpCG;
import org.overture.codegen.cgast.expressions.ATimesNumericBinaryExpCG;
import org.overture.codegen.cgast.expressions.ATupleExpCG;
import org.overture.codegen.cgast.expressions.AVariableExpCG;
import org.overture.codegen.cgast.expressions.AXorBoolBinaryExpCG;
import org.overture.codegen.cgast.expressions.PExpCG;
import org.overture.codegen.cgast.name.ATypeNameCG;
import org.overture.codegen.cgast.pattern.AIdentifierPatternCG;
import org.overture.codegen.cgast.patterns.ASetMultipleBindCG;
import org.overture.codegen.cgast.patterns.PMultipleBindCG;
import org.overture.codegen.cgast.types.AClassTypeCG;
import org.overture.codegen.cgast.types.ARealNumericBasicTypeCG;
import org.overture.codegen.cgast.types.ARecordTypeCG;
import org.overture.codegen.cgast.types.PTypeCG;
import org.overture.codegen.cgast.utils.AHeaderLetBeStCG;
import org.overture.codegen.constants.IOoAstConstants;
import org.overture.codegen.ooast.OoAstInfo;
import org.overture.codegen.utils.AnalysisExceptionCG;

public class ExpVisitorCG extends AbstractVisitorCG<OoAstInfo, PExpCG>
{
	@Override
	public PExpCG caseANilExp(ANilExp node, OoAstInfo question)
			throws AnalysisException
	{
		return new ANullExpCG();
	}
	
	@Override
	public PExpCG caseAMkBasicExp(AMkBasicExp node, OoAstInfo question)
			throws AnalysisException
	{
		PType type = node.getType();
		
		if(!(type instanceof ATokenBasicType))
		{
			question.addUnsupportedNode(node, "Expected token type for mk basic expression. Got: " + type);
			return null;
		}
		
		PExp arg = node.getArg();
		
		PTypeCG typeCg = type.apply(question.getTypeVisitor(), question);
		PExpCG argCg = arg.apply(question.getExpVisitor(), question);

		AMkBasicExpCG mkBasicExp = new AMkBasicExpCG();
		mkBasicExp.setType(typeCg);
		mkBasicExp.setArg(argCg);
		
		return mkBasicExp;
	}
	
	@Override
	public PExpCG caseAIsOfClassExp(AIsOfClassExp node, OoAstInfo question)
			throws AnalysisException
	{
		PType type = node.getType();
		AClassType classType = node.getClassType();
		PExp objRef = node.getExp();

		PTypeCG typeCg = type.apply(question.getTypeVisitor(), question);
		PTypeCG classTypeCg = classType.apply(question.getTypeVisitor(), question);

		if (!(classTypeCg instanceof AClassTypeCG))
			throw new AnalysisExceptionCG("Unexpected class type encountered for "
					+ AIsOfClassExp.class.getName() + ". Expected class type: "
					+ AClassTypeCG.class.getName() + ". Got: " + typeCg.getClass().getName(), node.getLocation());

		PExpCG objRefCg = objRef.apply(question.getExpVisitor(), question);

		AInstanceofExpCG instanceOfExp = new AInstanceofExpCG();
		instanceOfExp.setType(typeCg);
		instanceOfExp.setClassType((AClassTypeCG) classTypeCg);
		instanceOfExp.setObjRef(objRefCg);
		
		return instanceOfExp;
	}
	
	@Override
	public PExpCG caseACardinalityUnaryExp(ACardinalityUnaryExp node,
			OoAstInfo question) throws AnalysisException
	{
		return question.getExpAssistant().handleUnaryExp(node, new ASizeUnaryExpCG(), question);
	}
	
	@Override
	public PExpCG caseAInSetBinaryExp(AInSetBinaryExp node, OoAstInfo question)
			throws AnalysisException
	{
		return question.getExpAssistant().handleBinaryExp(node,  new AInSetBinaryExpCG(), question);
	}
	
	@Override
	public PExpCG caseANotInSetBinaryExp(ANotInSetBinaryExp node,
			OoAstInfo question) throws AnalysisException
	{
		return question.getExpAssistant().negate(question.getExpAssistant().handleBinaryExp(node,  new AInSetBinaryExpCG(), question));
	}
	
	@Override
	public PExpCG caseASetUnionBinaryExp(ASetUnionBinaryExp node,
			OoAstInfo question) throws AnalysisException
	{
		return question.getExpAssistant().handleBinaryExp(node,  new ASetUnionBinaryExpCG(), question);
	}
	
	@Override
	public PExpCG caseASetIntersectBinaryExp(ASetIntersectBinaryExp node,
			OoAstInfo question) throws AnalysisException
	{
		return question.getExpAssistant().handleBinaryExp(node, new ASetIntersectBinaryExpCG(), question);
	}
	
	@Override
	public PExpCG caseASetDifferenceBinaryExp(ASetDifferenceBinaryExp node,
			OoAstInfo question) throws AnalysisException
	{
		return question.getExpAssistant().handleBinaryExp(node, new ASetDifferenceBinaryExpCG(), question);
	}
	
	@Override
	public PExpCG caseASubsetBinaryExp(ASubsetBinaryExp node, OoAstInfo question)
			throws AnalysisException
	{
		return question.getExpAssistant().handleBinaryExp(node, new ASetSubsetBinaryExpCG(), question);
	}
	
	@Override
	public PExpCG caseAProperSubsetBinaryExp(AProperSubsetBinaryExp node,
			OoAstInfo question) throws AnalysisException
	{
		return question.getExpAssistant().handleBinaryExp(node, new ASetProperSubsetBinaryExpCG(), question);
	}
	
	@Override
	public PExpCG caseADistUnionUnaryExp(ADistUnionUnaryExp node,
			OoAstInfo question) throws AnalysisException
	{
		return question.getExpAssistant().handleUnaryExp(node, new ADistUnionUnaryExpCG(), question);
	}
	
	@Override
	public PExpCG caseADistIntersectUnaryExp(ADistIntersectUnaryExp node,
			OoAstInfo question) throws AnalysisException
	{
		return question.getExpAssistant().handleUnaryExp(node, new ADistIntersectUnaryExpCG(), question);
	}
	
	@Override
	public PExpCG caseAPowerSetUnaryExp(APowerSetUnaryExp node,
			OoAstInfo question) throws AnalysisException
	{
		return question.getExpAssistant().handleUnaryExp(node, new APowerSetUnaryExpCG(), question);
	}
	
	@Override
	public PExpCG caseASetEnumSetExp(ASetEnumSetExp node, OoAstInfo question)
			throws AnalysisException
	{
		PType type = node.getType();
		
		if(!(type instanceof ASetType))
			throw new AnalysisExceptionCG("Unexpected set type for set enumeration expression: " + type.getClass().getName(), node.getLocation());
		
		LinkedList<PExp> members = node.getMembers();
		
		AEnumSetExpCG enumSet = new AEnumSetExpCG();
		
		PTypeCG typeCg = type.apply(question.getTypeVisitor(), question);
		enumSet.setType(typeCg);
		LinkedList<PExpCG> membersCg = enumSet.getMembers();
		
		for(PExp member : members)
		{
			membersCg.add(member.apply(question.getExpVisitor(), question));
		}
	
		return enumSet;
	}
	
	
	@Override
	public PExpCG caseAForAllExp(AForAllExp node, OoAstInfo question)
			throws AnalysisException
	{
		
		if(question.getExpAssistant().existsOutsideOpOrFunc(node))
		{
			question.addUnsupportedNode(node, "Generation of a for all expression is only supported within operations/functions");
			return null;
		}
		
		LinkedList<PMultipleBind> bindings = node.getBindList();

		LinkedList<ASetMultipleBindCG> bindingsCg = new LinkedList<ASetMultipleBindCG>();
		for (PMultipleBind multipleBind : bindings)
		{
			if(!(multipleBind instanceof ASetMultipleBind))
			{
				question.addUnsupportedNode(node, "Generation of a for all expression is only supported for multiple set binds. Got: "
						+ multipleBind);
				return null;
			}
			
			PMultipleBindCG multipleBindCg = multipleBind.apply(question.getMultipleBindVisitor(), question);
			
			if (!(multipleBindCg instanceof ASetMultipleBindCG))
			{
				question.addUnsupportedNode(node, "Generation of a multiple set bind was expected to yield a ASetMultipleBindCG. Got: " + multipleBindCg);
			}
			
			bindingsCg.add((ASetMultipleBindCG) multipleBindCg);
		}
		
		PType type = node.getType();
		PExp predicate = node.getPredicate();
		
		PTypeCG typeCg = type.apply(question.getTypeVisitor(), question);
		PExpCG predicateCg = predicate.apply(question.getExpVisitor(), question);
		String varCg = question.getTempVarNameGen().nextVarName(IOoAstConstants.GENERATED_TEMP_FORALL_EXP_NAME_PREFIX);
		
		AForAllExpCG forAll = new AForAllExpCG();
		forAll.setType(typeCg);
		forAll.setBindList(bindingsCg);
		forAll.setPredicate(predicateCg);
		forAll.setVar(varCg);
		
		return forAll;
	}

	@Override
	public PExpCG caseASetCompSetExp(ASetCompSetExp node, OoAstInfo question)
			throws AnalysisException
	{
		if (question.getExpAssistant().existsOutsideOpOrFunc(node))
		{
			question.addUnsupportedNode(node, "Generation of a set comprehension is only supported within operations/functions");
			return null;
		}
		
		LinkedList<PMultipleBind> bindings = node.getBindings();

		LinkedList<ASetMultipleBindCG> bindingsCg = new LinkedList<ASetMultipleBindCG>();
		for (PMultipleBind multipleBind : bindings)
		{
			if(!(multipleBind instanceof ASetMultipleBind))
			{
				question.addUnsupportedNode(node, "Generation of a set comprehension is only supported for multiple set binds. Got: "
						+ multipleBind);
				return null;
			}
			
			PMultipleBindCG multipleBindCg = multipleBind.apply(question.getMultipleBindVisitor(), question);
			
			if (!(multipleBindCg instanceof ASetMultipleBindCG))
			{
				question.addUnsupportedNode(node, "Generation of a multiple set bind was expected to yield a ASetMultipleBindCG. Got: " + multipleBindCg);
			}
			
			bindingsCg.add((ASetMultipleBindCG) multipleBindCg);
		}
		
		PType type = node.getType();
		PExp first = node.getFirst();
		PExp predicate = node.getPredicate();
		
		PTypeCG typeCg = type.apply(question.getTypeVisitor(), question);
		PExpCG firstCg = first.apply(question.getExpVisitor(), question);
		PExpCG predicateCg = predicate != null ? predicate.apply(question.getExpVisitor(), question) : null;
		String varCg = question.getTempVarNameGen().nextVarName(IOoAstConstants.GENERATED_TEMP_SET_COMP_NAME_PREFIX);

		ACompSetExpCG setComp = new ACompSetExpCG();
		setComp.setBindings(bindingsCg);
		setComp.setType(typeCg);
		setComp.setFirst(firstCg);
		setComp.setPredicate(predicateCg);
		setComp.setVar(varCg);
		
		return setComp;
	}
	
	@Override
	public PExpCG caseASetRangeSetExp(ASetRangeSetExp node, OoAstInfo question)
			throws AnalysisException
	{
		PType type = node.getType();
		PExp firstExp = node.getFirst();
		PExp lastExp = node.getLast();

		PTypeCG typeCg = type.apply(question.getTypeVisitor(), question);
		PExpCG firstExpCg = firstExp.apply(question.getExpVisitor(), question);
		PExpCG lastExpCg = lastExp.apply(question.getExpVisitor(), question);
		
		ARangeSetExpCG setRange = new ARangeSetExpCG();
		
		setRange.setType(typeCg);
		setRange.setFirst(firstExpCg);
		setRange.setLast(lastExpCg);
		
		return setRange;
	}
	
	@Override
	public PExpCG caseAIfExp(AIfExp node, OoAstInfo question)
			throws AnalysisException
	{
		PExpCG testExp = node.getTest().apply(question.getExpVisitor(), question);
		PExpCG thenExp = node.getThen().apply(question.getExpVisitor(), question);
		PTypeCG expectedType = node.getType().apply(question.getTypeVisitor(), question);
		
		ATernaryIfExpCG ternaryIf = new ATernaryIfExpCG();
		
		ternaryIf.setCondition(testExp);
		ternaryIf.setTrueValue(thenExp);
		ternaryIf.setType(expectedType);
		
		LinkedList<AElseIfExp> elseExpList = node.getElseList();
		
		ATernaryIfExpCG nextTernaryIf = ternaryIf;
		
		for (AElseIfExp currentElseExp : elseExpList)
		{
			ATernaryIfExpCG tmp = new ATernaryIfExpCG();
			
			testExp = currentElseExp.getElseIf().apply(question.getExpVisitor(), question);
			thenExp = currentElseExp.getThen().apply(question.getExpVisitor(), question);
			expectedType = currentElseExp.getType().apply(question.getTypeVisitor(), question);
			
			tmp.setCondition(testExp);
			tmp.setTrueValue(thenExp);
			tmp.setType(expectedType);
			
			nextTernaryIf.setFalseValue(tmp);
			nextTernaryIf = tmp;
			
		}
		
		PExpCG elseExp = node.getElse().apply(question.getExpVisitor(), question);
		nextTernaryIf.setFalseValue(elseExp);
		
		if(node.parent() instanceof SBinaryExp)
			return question.getExpAssistant().isolateExpression(ternaryIf);
		
		return ternaryIf;
	}
	
	@Override
	public PExpCG caseATupleExp(ATupleExp node, OoAstInfo question)
			throws AnalysisException
	{
		PType type = node.getType();
		LinkedList<PExp> args = node.getArgs();
		
		PTypeCG typeCg = type.apply(question.getTypeVisitor(), question);
		
		ATupleExpCG tupleExp = new ATupleExpCG();
		tupleExp.setType(typeCg);
		
		for (PExp exp : args)
		{
			PExpCG expCg = exp.apply(question.getExpVisitor(), question);
			tupleExp.getArgs().add(expCg);
		}
		
		return tupleExp;
	}
	
	@Override
	public PExpCG caseAFieldNumberExp(AFieldNumberExp node, OoAstInfo question)
			throws AnalysisException
	{
		long fieldCg = node.getField().getValue();
		PType type = node.getType();
		PExp tuple = node.getTuple();

		AFieldNumberExpCG fieldNoExp = new AFieldNumberExpCG();
		PExpCG tupleCg = tuple.apply(question.getExpVisitor(), question);
		PTypeCG typeCg = type.apply(question.getTypeVisitor(), question);
		
		fieldNoExp.setField(fieldCg);
		fieldNoExp.setType(typeCg);
		fieldNoExp.setTuple(tupleCg);
		
		return fieldNoExp;
	}
	
	@Override
	public PExpCG caseAFuncInstatiationExp(AFuncInstatiationExp node,
			OoAstInfo question) throws AnalysisException
	{
		String name = node.getExpdef().getName().getName();
		LinkedList<PType> actualTypes = node.getActualTypes();
		
		AMethodInstantiationExpCG methodInst = new AMethodInstantiationExpCG();
		methodInst.setType(null);
		methodInst.setName(name);
		
		for (PType type : actualTypes)
		{
			PTypeCG typeCG = type.apply(question.getTypeVisitor(), question);
			methodInst.getActualTypes().add(typeCG);
		}
		
		return methodInst;
	}
	
	@Override
	public PExpCG caseALetBeStExp(ALetBeStExp node, OoAstInfo question)
			throws AnalysisException
	{
		if (question.getExpAssistant().existsOutsideOpOrFunc(node))
		{
			question.addUnsupportedNode(node, "Generation of a let be st expression is only supported within operations/functions");
			return null;
		}
		
		PMultipleBind multipleBind = node.getBind();
		
		if(!(multipleBind instanceof ASetMultipleBind))
		{
			question.addUnsupportedNode(node, "Generation of the let be st expression is only supported for a multiple set bind. Got: " + multipleBind);
			return null;
		}
		
		ASetMultipleBind multipleSetBind = (ASetMultipleBind) multipleBind;
		
		PMultipleBindCG multipleBindCg = multipleSetBind.apply(question.getMultipleBindVisitor(), question);
		
		if(!(multipleBindCg instanceof ASetMultipleBindCG))
		{
			question.addUnsupportedNode(node, "Generation of a multiple set bind was expected to yield a ASetMultipleBindCG. Got: " + multipleBindCg);
			return null;
		}
		
		ASetMultipleBindCG multipleSetBindCg = (ASetMultipleBindCG) multipleBindCg;
		
		PType type = node.getType();
		PExp suchThat = node.getSuchThat();
		PExp value = node.getValue();
		
		PTypeCG typeCg = type.apply(question.getTypeVisitor(), question);
		PExpCG suchThatCg = suchThat != null ? suchThat.apply(question.getExpVisitor(), question) : null;
		PExpCG valueCg = value.apply(question.getExpVisitor(), question);
		String varCg = question.getTempVarNameGen().nextVarName(IOoAstConstants.GENERATED_TEMP_LET_BE_ST_EXP_NAME_PREFIX);
		
		ALetBeStExpCG letBeStExp = new ALetBeStExpCG();
		
		AHeaderLetBeStCG header = question.getExpAssistant().consHeader(multipleSetBindCg, suchThatCg);

		letBeStExp.setType(typeCg);
		letBeStExp.setHeader(header);
		letBeStExp.setValue(valueCg);
		letBeStExp.setVar(varCg);
		
		return letBeStExp;
	}
	
	@Override
	public PExpCG caseALetDefExp(ALetDefExp node, OoAstInfo question)
			throws AnalysisException
	{
		if(question.getExpAssistant().isAssigned(node))
		{
			question.addUnsupportedNode(node, "Generation of a let expression is not supported in assignments");
			return null;
		}
		
		ALetDefExpCG localDefExp = new ALetDefExpCG();
	
		question.getDeclAssistant().setLocalDefs(node.getLocalDefs(), localDefExp.getLocalDefs(), question);
		
		PExpCG exp = node.getExpression().apply(question.getExpVisitor(), question);
		localDefExp.setExp(exp);
		
		return localDefExp;
	}

	
	@Override
	public PExpCG caseAMkTypeExp(AMkTypeExp node, OoAstInfo question)
			throws AnalysisException
	{
		ARecordInvariantType recType = node.getRecordType();
		
		if(recType == null)
			throw new AnalysisExceptionCG("Expected record type for mk_<type> expression.", node.getLocation());
		
		PTypeCG typeCg = recType.apply(question.getTypeVisitor(), question);
		
		if(!(typeCg instanceof ARecordTypeCG))
			throw new AnalysisExceptionCG("Expected record type but got: " + typeCg.getClass().getName() + " in 'mk_' expression", node.getLocation());
		
		ARecordTypeCG recordTypeCg = (ARecordTypeCG) typeCg;
		
		LinkedList<PExp> nodeArgs = node.getArgs();
		
		ANewExpCG newExp = new ANewExpCG();
		newExp.setType(recordTypeCg);
		newExp.setName(recordTypeCg.getName().clone());

		LinkedList<PExpCG> newExpArgs = newExp.getArgs();
		
		for (PExp arg : nodeArgs)
		{
			newExpArgs.add(arg.apply(question.getExpVisitor(), question));
		}
		
		return newExp;
	}
	
	@Override
	public PExpCG caseASelfExp(ASelfExp node, OoAstInfo question)
			throws AnalysisException
	{
		return new ASelfExpCG();
	}
	
	@Override
	public PExpCG caseAReverseUnaryExp(AReverseUnaryExp node, OoAstInfo question)
			throws AnalysisException
	{
		PExp exp = node.getExp();
		PType type = node.getType();

		if (!(type instanceof SSeqType))
			throw new AnalysisExceptionCG("Unexpected sequence type for reverse unary expression: "
					+ type.getClass().getName(), node.getLocation());

		SSeqType seqType = ((SSeqType) type);

		PTypeCG seqTypeCg = seqType.apply(question.getTypeVisitor(), question);
		PExpCG expCg = exp.apply(question.getExpVisitor(), question);

		AReverseUnaryExpCG reverse = new AReverseUnaryExpCG();
		reverse.setExp(expCg);
		reverse.setType(seqTypeCg);

		return reverse;
	}
	
	@Override
	public PExpCG caseADistConcatUnaryExp(ADistConcatUnaryExp node,
			OoAstInfo question) throws AnalysisException
	{
		return question.getExpAssistant().handleUnaryExp(node, new ADistConcatUnaryExpCG(), question);
	}
	
	@Override
	public PExpCG caseASeqCompSeqExp(ASeqCompSeqExp node, OoAstInfo question)
			throws AnalysisException
	{
		if (question.getExpAssistant().existsOutsideOpOrFunc(node))
		{
			question.addUnsupportedNode(node, "Generation of a sequence comprehension is only supported within operations/functions");
			return null;
		}
		
		PPattern pattern = node.getSetBind().getPattern();
		
		if(!(pattern instanceof AIdentifierPattern))
		{
			question.addUnsupportedNode(node, "Generation of a sequence comprehension is only supported for identifier patterns");
			return null;
		}
		
		AIdentifierPattern setBindId = (AIdentifierPattern) pattern;
		PType type = node.getType();
		PExp first = node.getFirst();
		PExp set = node.getSetBind().getSet();
		PExp predicate = node.getPredicate();

		AIdentifierPatternCG id = new AIdentifierPatternCG();
		id.setName(setBindId.getName().getName());
		
		PTypeCG typeCg = type.apply(question.getTypeVisitor(), question);
		PExpCG firstCg = first.apply(question.getExpVisitor(), question);
		PExpCG setCg = set.apply(question.getExpVisitor(), question);
		PExpCG predicateCg = predicate != null ? predicate.apply(question.getExpVisitor(), question) : null;
		String varCg = question.getTempVarNameGen().nextVarName(IOoAstConstants.GENERATED_TEMP_SEQ_COMP_NAME_PREFIX);
		
		ACompSeqExpCG seqComp = new ACompSeqExpCG();
		seqComp.setId(id);
		seqComp.setType(typeCg);
		seqComp.setFirst(firstCg);
		seqComp.setSet(setCg);
		seqComp.setPredicate(predicateCg);
		seqComp.setVar(varCg);
		
		return seqComp;
	}
	
	@Override
	public PExpCG caseASeqConcatBinaryExp(ASeqConcatBinaryExp node,
			OoAstInfo question) throws AnalysisException
	{
		return question.getExpAssistant().handleBinaryExp(node,  new ASeqConcatBinaryExpCG(), question);
	}
	
	@Override
	public PExpCG caseAPlusPlusBinaryExp(APlusPlusBinaryExp node,
			OoAstInfo question) throws AnalysisException
	{
		PType leftType = node.getLeft().getType();
		
		if(leftType instanceof SSeqType)
			return question.getExpAssistant().handleBinaryExp(node, new ASeqModificationBinaryExpCG(), question);
		else if(leftType instanceof SMapType)
			return question.getExpAssistant().handleBinaryExp(node, new AMapOverrideBinaryExpCG(), question);
					
		throw new AnalysisExceptionCG("Expected sequence or map type for '++' binary expression but got: " + leftType, node.getLocation());			
	}
	
	@Override
	public PExpCG caseAMapEnumMapExp(AMapEnumMapExp node, OoAstInfo question)
			throws AnalysisException
	{
		PType type = node.getType();
		
		PTypeCG typeCg = type.apply(question.getTypeVisitor(), question);
		
		AEnumMapExpCG enumMap = new AEnumMapExpCG();
		enumMap.setType(typeCg);
		
		LinkedList<AMapletExp> members = node.getMembers();
		for (PExp member : members)
		{
			PExpCG exp = member.apply(question.getExpVisitor(), question);
			
			if(!(exp instanceof AMapletExpCG))
				throw new AnalysisExceptionCG("Got expected map enumeration member: " + exp, member.getLocation());
			
			enumMap.getMembers().add((AMapletExpCG) exp);
		}
		
		return enumMap;
	}
	
	@Override
	public PExpCG caseAMapletExp(AMapletExp node, OoAstInfo question)
			throws AnalysisException
	{
		PType type = node.getType();
		
		PExp left = node.getLeft();
		PExp right = node.getRight();

		PTypeCG typeCg = type.apply(question.getTypeVisitor(), question);
		
		PExpCG leftCg = left.apply(question.getExpVisitor(), question);
		PExpCG rightCg = right.apply(question.getExpVisitor(), question);
		
		AMapletExpCG maplet = new AMapletExpCG();
		maplet.setType(typeCg);
		maplet.setLeft(leftCg);
		maplet.setRight(rightCg);
		
		return maplet;
	}
	
	@Override
	public PExpCG caseAMapCompMapExp(AMapCompMapExp node, OoAstInfo question)
			throws AnalysisException
	{
		if (question.getExpAssistant().existsOutsideOpOrFunc(node))
		{
			question.addUnsupportedNode(node, "Generation of a map comprehension is only supported within operations/functions");
			return null;
		}
		
		LinkedList<PMultipleBind> bindings = node.getBindings();
		PType type = node.getType();
		AMapletExp first = node.getFirst();
		PExp predicate = node.getPredicate();
		
		LinkedList<ASetMultipleBindCG> bindingsCg = new LinkedList<ASetMultipleBindCG>();
		for (PMultipleBind multipleBind : bindings)
		{
			if(!(multipleBind instanceof ASetMultipleBind))
			{
				question.addUnsupportedNode(node, "Generation of a map comprehension is only supported for multiple set binds. Got: "
						+ multipleBind);
				return null;
			}
			
			PMultipleBindCG multipleBindCg = multipleBind.apply(question.getMultipleBindVisitor(), question);
			
			if (!(multipleBindCg instanceof ASetMultipleBindCG))
			{
				question.addUnsupportedNode(node, "Generation of a multiple set bind was expected to yield a ASetMultipleBindCG. Got: " + multipleBindCg);
			}
			
			bindingsCg.add((ASetMultipleBindCG) multipleBindCg);
		}
		
		PTypeCG typeCg = type.apply(question.getTypeVisitor(), question);
		PExpCG firstCg = first.apply(question.getExpVisitor(), question);
		PExpCG predicateCg = predicate != null ? predicate.apply(question.getExpVisitor(), question) : null;
		String varCg = question.getTempVarNameGen().nextVarName(IOoAstConstants.GENERATED_TEMP_MAP_COMP_NAME_PREFIX);
		
		if(!(firstCg instanceof AMapletExpCG))
		{
			question.addUnsupportedNode(node, "Generation of map comprehension expected a maplet expression. Got: " + firstCg);
		}
		
		AMapletExpCG mapletExpCg = (AMapletExpCG) firstCg;
		
		ACompMapExpCG mapComp = new ACompMapExpCG();
		
		mapComp.setBindings(bindingsCg);
		mapComp.setType(typeCg);
		mapComp.setFirst(mapletExpCg);
		mapComp.setPredicate(predicateCg);
		mapComp.setVar(varCg);

		return mapComp;
	}
	
	@Override
	public PExpCG caseAMapDomainUnaryExp(AMapDomainUnaryExp node,
			OoAstInfo question) throws AnalysisException
	{
		return question.getExpAssistant().handleUnaryExp(node, new AMapDomainUnaryExpCG(), question);
	}
	
	@Override
	public PExpCG caseAMapRangeUnaryExp(AMapRangeUnaryExp node,
			OoAstInfo question) throws AnalysisException
	{
		return question.getExpAssistant().handleUnaryExp(node, new AMapRangeUnaryExpCG(), question);
	}
	
	@Override
	public PExpCG caseAMapUnionBinaryExp(AMapUnionBinaryExp node,
			OoAstInfo question) throws AnalysisException
	{
		return question.getExpAssistant().handleBinaryExp(node, new AMapUnionBinaryExpCG(), question);
	}
	
	@Override
	public PExpCG caseADistMergeUnaryExp(ADistMergeUnaryExp node,
			OoAstInfo question) throws AnalysisException
	{
		return question.getExpAssistant().handleUnaryExp(node, new ADistMergeUnaryExpCG(), question);
	}
	
	@Override
	public PExpCG caseADomainResToBinaryExp(ADomainResToBinaryExp node,
			OoAstInfo question) throws AnalysisException
	{
		return question.getExpAssistant().handleBinaryExp(node, new ADomainResToBinaryExpCG(), question);
	}
	
	@Override
	public PExpCG caseADomainResByBinaryExp(ADomainResByBinaryExp node,
			OoAstInfo question) throws AnalysisException
	{
		return question.getExpAssistant().handleBinaryExp(node, new ADomainResByBinaryExpCG(), question);
	}
	
	@Override
	public PExpCG caseARangeResToBinaryExp(ARangeResToBinaryExp node,
			OoAstInfo question) throws AnalysisException
	{
		return question.getExpAssistant().handleBinaryExp(node, new ARangeResToBinaryExpCG(), question);
	}
	
	@Override
	public PExpCG caseARangeResByBinaryExp(ARangeResByBinaryExp node,
			OoAstInfo question) throws AnalysisException
	{
		return question.getExpAssistant().handleBinaryExp(node, new ARangeResByBinaryExpCG(), question);
	}
	
	@Override
	public PExpCG caseAMapInverseUnaryExp(AMapInverseUnaryExp node,
			OoAstInfo question) throws AnalysisException
	{
		return question.getExpAssistant().handleUnaryExp(node, new AMapInverseUnaryExpCG(), question);
	}
	
	@Override
	public PExpCG caseAEqualsBinaryExp(AEqualsBinaryExp node,
			OoAstInfo question) throws AnalysisException
	{	
		return question.getExpAssistant().handleBinaryExp(node, new AEqualsBinaryExpCG(), question);
	}
	
	@Override
	public PExpCG caseANotEqualBinaryExp(ANotEqualBinaryExp node,
			OoAstInfo question) throws AnalysisException
	{
		return question.getExpAssistant().handleBinaryExp(node, new ANotEqualsBinaryExpCG(), question);
	}
	
	@Override
	public PExpCG caseAIndicesUnaryExp(AIndicesUnaryExp node, OoAstInfo question)
			throws AnalysisException
	{
		PType expType = node.getExp().getType();
		
		if(!(expType instanceof SSeqType))
			throw new AnalysisExceptionCG("Expected sequence type for indices unary expression. Got: " + node.getClass().getName(), node.getLocation());
		
		PExp exp = node.getExp();
		
		PTypeCG typeCg = expType.apply(question.getTypeVisitor(), question);
		PExpCG expCg = exp.apply(question.getExpVisitor(), question);
		
		AIndicesUnaryExpCG indicesExp = new AIndicesUnaryExpCG();
		indicesExp.setType(typeCg);
		indicesExp.setExp(expCg);
		
		return indicesExp;
	}
	
	@Override
	public PExpCG caseASeqEnumSeqExp(ASeqEnumSeqExp node, OoAstInfo question)
			throws AnalysisException
	{	
		AEnumSeqExpCG enumSeq = new AEnumSeqExpCG();
		
		PType type = node.getType();
		if(type instanceof SSeqType)
		{
			PTypeCG seqType = type.apply(question.getTypeVisitor(), question);
			enumSeq.setType(seqType);
		}
		else
		{
			throw new AnalysisExceptionCG("Unexpected sequence type for sequence enumeration expression: " + type.getClass().getName(), node.getLocation());
		}
		
		//TODO: For the empty sequence [] the type is the unknown type
		//This is a problem if the assignment var1 is a field
		//That has a declared type or we are talking about an assignment
		LinkedList<PExp> members = node.getMembers();
		for (PExp member : members)
		{
			enumSeq.getMembers().add(member.apply(question.getExpVisitor(), question));
		}
		
		return enumSeq;
	}
	
	@Override
	public PExpCG caseASubclassResponsibilityExp(
			ASubclassResponsibilityExp node, OoAstInfo question)
			throws AnalysisException
	{
		return null;//Indicates an abstract body
	}
	
	@Override
	public PExpCG caseAFieldExp(AFieldExp node, OoAstInfo question)
			throws AnalysisException
	{
		PExpCG object = node.getObject().apply(question.getExpVisitor(), question);
		PTypeCG type = node.getType().apply(question.getTypeVisitor(), question);
		
		String memberName = "";
		
		if(node.getMemberName() != null)
			memberName = node.getMemberName().getFullName();
		else
			memberName = node.getField().getName();
		
		AFieldExpCG fieldExp = new AFieldExpCG();
		fieldExp.setObject(object);
		fieldExp.setMemberName(memberName);
		fieldExp.setType(type);
		
		return fieldExp;
	}
	
	@Override
	public PExpCG caseAApplyExp(AApplyExp node, OoAstInfo question)
			throws AnalysisException
	{
		PType type = node.getType();
		PExp root = node.getRoot();

		PTypeCG typeCg = type.apply(question.getTypeVisitor(), question);
		PExpCG rootCg = root.apply(question.getExpVisitor(), question);

		AApplyExpCG applyExp = new AApplyExpCG();
		applyExp.setType(typeCg);
		applyExp.setRoot(rootCg);

		LinkedList<PExp> applyArgs = node.getArgs();

		for (int i = 0; i < applyArgs.size(); i++)
		{
			PExpCG arg = applyArgs.get(i).apply(question.getExpVisitor(), question);
			applyExp.getArgs().add(arg);
		}

		return applyExp;
	}
	
	@Override
	public PExpCG caseAVariableExp(AVariableExp node, OoAstInfo question)
			throws AnalysisException
	{
		String name = node.getName().getName();

		PDefinition varDef = node.getVardef();
		
		SClassDefinition owningClass = varDef.getAncestor(SClassDefinition.class);
		SClassDefinition nodeParentClass = node.getAncestor(SClassDefinition.class);

		boolean inOwningClass = owningClass == nodeParentClass;
		
		boolean isLocalDef = varDef instanceof ALocalDefinition;
		boolean isInstanceVarDef = varDef instanceof AInstanceVariableDefinition;
		boolean isAssignmentDef = varDef instanceof AAssignmentDefinition;
		
		boolean isDefInOwningClass = inOwningClass && (isLocalDef || isInstanceVarDef || isAssignmentDef);

		boolean isImplicit = !node.getName().getExplicit();
		
		PTypeCG typeCg = node.getType().apply(question.getTypeVisitor(), question);
		
		if (owningClass == null || isDefInOwningClass || isImplicit)
		{
			AVariableExpCG varExp = new AVariableExpCG();
			
			varExp.setOriginal(name);
			varExp.setType(typeCg);
			
			return varExp;
		}
		else if(node.getName().getExplicit())
		{
			AExplicitVariableExpCG varExp = new AExplicitVariableExpCG();
			
			String className = node.getName().getModule();
			
			AClassTypeCG classType = new AClassTypeCG();
			classType.setName(className);

			varExp.setType(typeCg);
			varExp.setClassType(classType);
			varExp.setName(name);
			
			return varExp;
		}
		else
			return null; 
	}
	
	@Override
	public PExpCG caseANewExp(ANewExp node, OoAstInfo question)
			throws AnalysisException
	{
		String className = node.getClassdef().getName().getName();
		ATypeNameCG typeName = new ATypeNameCG();
		typeName.setDefiningClass(null);
		typeName.setName(className);
		
		PType type = node.getType();
		LinkedList<PExp> nodeArgs = node.getArgs();

		ANewExpCG newExp = new ANewExpCG();

		PTypeCG typeCg = type.apply(question.getTypeVisitor(), question);
		newExp.setType(typeCg);
		newExp.setName(typeName);
		
		LinkedList<PExpCG> newExpArgs = newExp.getArgs();
		for (PExp arg : nodeArgs)
		{
			newExpArgs.add(arg.apply(question.getExpVisitor(), question));
		}
		
		return newExp;
	}
		
	@Override
	public PExpCG caseATimesNumericBinaryExp(ATimesNumericBinaryExp node,
			OoAstInfo question) throws AnalysisException
	{
		return question.getExpAssistant().handleBinaryExp(node, new ATimesNumericBinaryExpCG(), question);
	}
	
	@Override
	public PExpCG caseAPlusNumericBinaryExp(APlusNumericBinaryExp node,
			OoAstInfo question) throws AnalysisException
	{
		return question.getExpAssistant().handleBinaryExp(node, new APlusNumericBinaryExpCG(), question);
	}
	
	@Override
	public PExpCG caseASubtractNumericBinaryExp(ASubtractNumericBinaryExp node,
			OoAstInfo question) throws AnalysisException
	{
		return question.getExpAssistant().handleBinaryExp(node, new ASubtractNumericBinaryExpCG(), question);
	}
	
	@Override
	public PExpCG caseAGreaterEqualNumericBinaryExp(
			AGreaterEqualNumericBinaryExp node, OoAstInfo question)
			throws AnalysisException
	{
		return question.getExpAssistant().handleBinaryExp(node, new AGreaterEqualNumericBinaryExpCG(), question);
	}
	
	@Override
	public PExpCG caseAStarStarBinaryExp(AStarStarBinaryExp node,
			OoAstInfo question) throws AnalysisException
	{
		return question.getExpAssistant().handleBinaryExp(node, new APowerNumericBinaryExpCG(), question);
	}
	
	@Override
	public PExpCG caseAGreaterNumericBinaryExp(AGreaterNumericBinaryExp node,
			OoAstInfo question) throws AnalysisException
	{
		return question.getExpAssistant().handleBinaryExp(node, new AGreaterNumericBinaryExpCG(), question);
	}
	
	@Override
	public PExpCG caseALessEqualNumericBinaryExp(
			ALessEqualNumericBinaryExp node, OoAstInfo question)
			throws AnalysisException
	{
		return question.getExpAssistant().handleBinaryExp(node, new ALessEqualNumericBinaryExpCG(), question);
	}
	
	
	@Override
	public PExpCG caseALessNumericBinaryExp(ALessNumericBinaryExp node,
			OoAstInfo question) throws AnalysisException
	{
		return question.getExpAssistant().handleBinaryExp(node, new ALessNumericBinaryExpCG(), question);
	}
	
	@Override
	public PExpCG caseADivideNumericBinaryExp(ADivideNumericBinaryExp node,
			OoAstInfo question) throws AnalysisException
	{
		ADivideNumericBinaryExpCG divide = (ADivideNumericBinaryExpCG) question.getExpAssistant().handleBinaryExp(node, new ADivideNumericBinaryExpCG(), question);
		
		PExp leftExp = node.getLeft();
		PExp rightExp = node.getRight();
		
		PExpCG leftExpCG = divide.getLeft();
		
		if(question.getExpAssistant().isIntegerType(leftExp) && question.getExpAssistant().isIntegerType(rightExp))
		{
			ARealLiteralExpCG one = new ARealLiteralExpCG();
			one.setType(new ARealNumericBasicTypeCG());
			one.setValue(1.0);
			
			ATimesNumericBinaryExpCG neutralMul = new ATimesNumericBinaryExpCG();
			neutralMul.setType(new ARealNumericBasicTypeCG());
			neutralMul.setLeft(one);
			neutralMul.setRight(leftExpCG);
			
			divide.setLeft(question.getExpAssistant().isolateExpression(neutralMul));
		}
		
		return divide;
	}
	
	@Override
	public PExpCG caseADivNumericBinaryExp(ADivNumericBinaryExp node,
			OoAstInfo question) throws AnalysisException
	{
		return (ADivideNumericBinaryExpCG) question.getExpAssistant().handleBinaryExp(node, new ADivideNumericBinaryExpCG(), question);
	}
	
	@Override
	public PExpCG caseAModNumericBinaryExp(AModNumericBinaryExp node,
			OoAstInfo question) throws AnalysisException
	{
		//VDM Language Reference Manual:
		//x mod y = x - y * floor(x/y)
		
		PExp leftExp = node.getLeft();
		PExp rightExp = node.getRight();
		
		ADivideNumericBinaryExpCG div = (ADivideNumericBinaryExpCG) question.getExpAssistant().handleBinaryExp(node, new ADivideNumericBinaryExpCG(), question);
		AFloorUnaryExpCG floor = new AFloorUnaryExpCG();
		floor.setExp(div);
		
		PExpCG leftExpCg = leftExp.apply(question.getExpVisitor(), question);
		PExpCG rightExpCg = rightExp.apply(question.getExpVisitor(), question);
		
		ATimesNumericBinaryExpCG times = new ATimesNumericBinaryExpCG();
		times.setLeft(rightExpCg);
		times.setRight(floor);
		
		ASubtractNumericBinaryExpCG sub = new ASubtractNumericBinaryExpCG();
		sub.setLeft(leftExpCg);
		sub.setRight(times);
		
		return (node.parent() instanceof SBinaryExp) ? question.getExpAssistant().isolateExpression(sub) : sub;
	}
	
	@Override
	public PExpCG caseARemNumericBinaryExp(ARemNumericBinaryExp node,
			OoAstInfo question) throws AnalysisException
	{
		//VDM Language Reference Manual:
		//x rem y = x - y * (x div y)
		
		PExp leftExp = node.getLeft();
		PExp rightExp = node.getRight();
		
		ADivideNumericBinaryExpCG div = (ADivideNumericBinaryExpCG) question.getExpAssistant().handleBinaryExp(node, new ADivideNumericBinaryExpCG(), question);
		
		PExpCG leftExpCg = leftExp.apply(question.getExpVisitor(), question);
		PExpCG rightExpCg = rightExp.apply(question.getExpVisitor(), question);
		
		ATimesNumericBinaryExpCG times = new ATimesNumericBinaryExpCG();
		times.setLeft(rightExpCg);
		times.setRight(question.getExpAssistant().isolateExpression(div));
		
		ASubtractNumericBinaryExpCG sub = new ASubtractNumericBinaryExpCG();
		sub.setLeft(leftExpCg);
		sub.setRight(times);
		
		return (node.parent() instanceof SBinaryExp) ? question.getExpAssistant().isolateExpression(sub) : sub;
	}
				
	@Override
	public PExpCG caseAImpliesBooleanBinaryExp(AImpliesBooleanBinaryExp node,
			OoAstInfo question) throws AnalysisException
	{
		//A => B is constructed as !A || B
		
		PTypeCG typeCg = node.getType().apply(question.getTypeVisitor(), question);
		PExpCG leftExpCg = node.getLeft().apply(question.getExpVisitor(), question);
		PExpCG rightExpCg = node.getRight().apply(question.getExpVisitor(), question);
		
		ANotUnaryExpCG notExp = new ANotUnaryExpCG();
		notExp.setType(typeCg);
		notExp.setExp(leftExpCg);
		
		AOrBoolBinaryExpCG orExp = new AOrBoolBinaryExpCG();
		orExp.setType(typeCg);
		orExp.setLeft(notExp);
		orExp.setRight(rightExpCg);
		
		return orExp;
	}
	
	@Override
	public PExpCG caseAEquivalentBooleanBinaryExp(
			AEquivalentBooleanBinaryExp node, OoAstInfo question)
			throws AnalysisException
	{
		//A <=> B is constructed as !(A ^ B)
		PTypeCG typeCg = node.getType().apply(question.getTypeVisitor(), question);
		PExpCG leftExpCg = node.getLeft().apply(question.getExpVisitor(), question);
		PExpCG rightExpCg = node.getRight().apply(question.getExpVisitor(), question);

		AXorBoolBinaryExpCG xorExp = new AXorBoolBinaryExpCG();
		xorExp.setType(typeCg);
		xorExp.setLeft(leftExpCg);
		xorExp.setRight(rightExpCg);
		
		ANotUnaryExpCG notExp = new ANotUnaryExpCG();
		notExp.setType(typeCg);
		notExp.setExp(question.getExpAssistant().isolateExpression(xorExp));

		return notExp;
	}
	
	//Unary
	
	@Override
	public PExpCG caseAUnaryPlusUnaryExp(AUnaryPlusUnaryExp node, OoAstInfo question) throws AnalysisException
	{
		return question.getExpAssistant().handleUnaryExp(node, new APlusUnaryExpCG(), question);
	}

	@Override
	public PExpCG caseAUnaryMinusUnaryExp(AUnaryMinusUnaryExp node,
			OoAstInfo question) throws AnalysisException
	{
		return question.getExpAssistant().handleUnaryExp(node, new AMinusUnaryExpCG(), question);
	}
	
	@Override
	public PExpCG caseAFloorUnaryExp(AFloorUnaryExp node, OoAstInfo question)
			throws AnalysisException
	{
		return question.getExpAssistant().handleUnaryExp(node, new AFloorUnaryExpCG(), question);
	}
	
	@Override
	public PExpCG caseAAbsoluteUnaryExp(AAbsoluteUnaryExp node,
			OoAstInfo question) throws AnalysisException
	{
		return question.getExpAssistant().handleUnaryExp(node, new AAbsUnaryExpCG(), question);
	}
	
	@Override
	public PExpCG caseANotUnaryExp(ANotUnaryExp node, OoAstInfo question)
			throws AnalysisException
	{
		return question.getExpAssistant().handleUnaryExp(node, new ANotUnaryExpCG(), question);
	}
	
	@Override
	public PExpCG caseAOrBooleanBinaryExp(AOrBooleanBinaryExp node,
			OoAstInfo question) throws AnalysisException
	{
		return question.getExpAssistant().handleBinaryExp(node,  new AOrBoolBinaryExpCG(), question);
	}
	
	@Override
	public PExpCG caseAAndBooleanBinaryExp(AAndBooleanBinaryExp node,
			OoAstInfo question) throws AnalysisException
	{
		return question.getExpAssistant().handleBinaryExp(node,  new AAndBoolBinaryExpCG(), question);
	}
	
	@Override
	public PExpCG caseALenUnaryExp(ALenUnaryExp node, OoAstInfo question)
			throws AnalysisException
	{
		return question.getExpAssistant().handleUnaryExp(node, new ASizeUnaryExpCG(), question);
	}
	
	@Override
	public PExpCG caseAElementsUnaryExp(AElementsUnaryExp node,
			OoAstInfo question) throws AnalysisException
	{
		return question.getExpAssistant().handleUnaryExp(node, new AElemsUnaryExpCG(), question);
	}
	
	@Override
	public PExpCG caseAHeadUnaryExp(AHeadUnaryExp node, OoAstInfo question)
			throws AnalysisException
	{
		return question.getExpAssistant().handleUnaryExp(node, new AHeadUnaryExpCG(), question);
	}
	
	@Override
	public PExpCG caseATailUnaryExp(ATailUnaryExp node, OoAstInfo question)
			throws AnalysisException
	{
		return question.getExpAssistant().handleUnaryExp(node, new ATailUnaryExpCG(), question);
	}
	
	//Literals
	//NOTE: The methods for handling of literals/constants look very similar and ideally should be
	//generalized in a method. However the nodes in the VDM AST don't share a parent with method
	//setValue at the current time of writing.
	
	@Override
	public PExpCG caseABooleanConstExp(ABooleanConstExp node,
			OoAstInfo question) throws AnalysisException
	{
		return question.getExpAssistant().consBoolLiteral(node.getValue().getValue());
	}
	
	@Override
	public PExpCG caseARealLiteralExp(ARealLiteralExp node,
			OoAstInfo question) throws AnalysisException
	{
		return question.getExpAssistant().consRealLiteral(node.getValue().getValue());
	}
	
	@Override
	public PExpCG caseAIntLiteralExp(AIntLiteralExp node,
			OoAstInfo question) throws AnalysisException
	{
		return question.getExpAssistant().consIntLiteral(node.getValue().getValue());
	}
	
	@Override
	public PExpCG caseACharLiteralExp(ACharLiteralExp node, OoAstInfo question)
			throws AnalysisException
	{
		return question.getExpAssistant().consCharLiteral(node.getValue().getValue());
	}
	
	@Override
	public PExpCG caseAStringLiteralExp(AStringLiteralExp node,
			OoAstInfo question) throws AnalysisException
	{
		return question.getExpAssistant().consStringLiteral(node.getValue().getValue(), false);
	}
	
	@Override
	public PExpCG caseAQuoteLiteralExp(AQuoteLiteralExp node,
			OoAstInfo question) throws AnalysisException
	{
		String value = node.getValue().getValue();
		PTypeCG type = node.getType().apply(question.getTypeVisitor(), question);

		AQuoteLiteralExpCG quoteLit = new AQuoteLiteralExpCG();
		quoteLit.setValue(value);
		quoteLit.setType(type);

		question.registerQuoteValue(value);
		
		return quoteLit;
	}
}