package org.overture.codegen.transform;

import org.overture.codegen.cgast.analysis.AnalysisException;
import org.overture.codegen.cgast.declarations.ALocalVarDeclCG;
import org.overture.codegen.cgast.expressions.AApplyExpCG;
import org.overture.codegen.cgast.expressions.ACastUnaryExpCG;
import org.overture.codegen.cgast.expressions.ACompSeqExpCG;
import org.overture.codegen.cgast.expressions.AExplicitVariableExpCG;
import org.overture.codegen.cgast.expressions.AVariableExpCG;
import org.overture.codegen.cgast.expressions.PExpCG;
import org.overture.codegen.cgast.statements.ABlockStmCG;
import org.overture.codegen.cgast.statements.ACallObjectStmCG;
import org.overture.codegen.cgast.statements.AIdentifierObjectDesignatorCG;
import org.overture.codegen.cgast.statements.AIfStmCG;
import org.overture.codegen.cgast.statements.PStmCG;
import org.overture.codegen.cgast.types.ASetSetTypeCG;
import org.overture.codegen.cgast.types.AVoidTypeCG;
import org.overture.codegen.cgast.types.PTypeCG;
import org.overture.codegen.cgast.types.SSeqTypeCG;
import org.overture.codegen.constants.IJavaCodeGenConstants;

public class CompAssistantCG extends TransformationAssistantCG
{
	public CompAssistantCG()
	{
	}

	public ACastUnaryExpCG consNextElementCall(String instance, String member, ACompSeqExpCG seqComp) throws AnalysisException
	{
		
		PTypeCG elementType = getSeqTypeCloned(seqComp).getSeqOf();
		
		PExpCG nextCall = consInstanceCall(consIteratorType() , instance, elementType.clone(), member , null);
		ACastUnaryExpCG cast = new ACastUnaryExpCG();
		cast.setType(elementType.clone());
		cast.setExp(nextCall);
		
		return cast;
	}

	public ALocalVarDeclCG consSetBindIdDecl(String instanceName, String memberName, ACompSeqExpCG seqComp) throws AnalysisException
	{
		SSeqTypeCG seqType = getSeqTypeCloned(seqComp);
		
		PTypeCG elementType = seqType.getSeqOf();
		String setBindId = seqComp.getSetBindId();
		ACastUnaryExpCG initExp = consNextElementCall(instanceName, memberName, seqComp);
		
		ALocalVarDeclCG idDecl = new ALocalVarDeclCG();
		idDecl.setType(elementType);
		idDecl.setName(setBindId);
		idDecl.setExp(initExp);
		
		return idDecl;
	}
	
	public ALocalVarDeclCG consSetBindDecl(String setBindName, ACompSeqExpCG seqComp) throws AnalysisException
	{	
		ASetSetTypeCG setType = new ASetSetTypeCG();
		setType.setSetOf(getSeqTypeCloned(seqComp).getSeqOf());
		
		ALocalVarDeclCG setBindDecl = new ALocalVarDeclCG();
		
		setBindDecl.setType(setType);
		setBindDecl.setName(setBindName);
		setBindDecl.setExp(seqComp.getSet());
		
		return setBindDecl;
	}
	
	public ALocalVarDeclCG consResultSeqDecl(String varDeclName, ACompSeqExpCG seqComp) throws AnalysisException
	{
		PTypeCG seqType = getSeqTypeCloned(seqComp);
		
		AExplicitVariableExpCG member = new AExplicitVariableExpCG();
		member.setType(seqType);
		member.setClassType(consClassType(IJavaCodeGenConstants.SEQ_UTIL_FILE));
		member.setName(IJavaCodeGenConstants.SEQ_UTIL_EMPTY_SEQ_CALL);

		AApplyExpCG call = new AApplyExpCG();
		call.setType(seqType.clone());
		call.setRoot(member);
		
		ALocalVarDeclCG resSeq = new ALocalVarDeclCG();
		resSeq.setType(seqType.clone());
		resSeq.setName(varDeclName);
		resSeq.setExp(call);
		
		return resSeq; 
	}

	public SSeqTypeCG getSeqTypeCloned(ACompSeqExpCG seqComp)
			throws AnalysisException
	{
		PTypeCG typeCg = seqComp.getType();
		
		if(!(typeCg instanceof SSeqTypeCG))
			throw new AnalysisException("Exptected sequence type for sequence comprehension. Got: " + typeCg);
		
		SSeqTypeCG seqTypeCg = (SSeqTypeCG) typeCg;
		
		return seqTypeCg.clone();
	}
	
	public PStmCG consConditionalAdd(String resultingSeqName, ACompSeqExpCG seqComp)
	{
		AVariableExpCG col = new AVariableExpCG();
		col.setOriginal(resultingSeqName);
		
		AIdentifierObjectDesignatorCG identifier = new AIdentifierObjectDesignatorCG();
		identifier.setExp(col);
		
		ACallObjectStmCG callStm = new ACallObjectStmCG();
		callStm.setClassName(null);
		callStm.setFieldName(IJavaCodeGenConstants.ADD_ELEMENT_TO_COLLECTION);
		callStm.setDesignator(identifier);
		callStm.getArgs().add(seqComp.getFirst());
		callStm.setType(new AVoidTypeCG());
		
		if(seqComp.getPredicate() != null)
		{
			AIfStmCG ifStm = new AIfStmCG();
			ifStm.setIfExp(seqComp.getPredicate());
			ifStm.setThenStm(callStm);
			
			return ifStm;
		}
		
		return callStm;
	}
	
	public ABlockStmCG consWhileBody(ACompSeqExpCG seqComp, String iteratorName,
			String resSeqName) throws AnalysisException
	{
		ABlockStmCG whileBody = new ABlockStmCG();
		whileBody.getLocalDefs().add(consSetBindIdDecl(iteratorName, IJavaCodeGenConstants.NEXT_ELEMENT_ITERATOR, seqComp));
		whileBody.getStatements().add(consConditionalAdd(resSeqName, seqComp));
		
		return whileBody;
	}
}