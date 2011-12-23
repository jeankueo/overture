/*******************************************************************************
 * Copyright (c) 2009, 2011 Overture Team and others.
 *
 * Overture is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Overture is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Overture.  If not, see <http://www.gnu.org/licenses/>.
 * 	
 * The Overture Tool web-site: http://overturetool.org/
 *******************************************************************************/
package org.overture.ide.plugins.poviewer.actions;


import org.overture.ast.modules.AModuleModules;
import org.overture.ide.core.IVdmModel;
import org.overture.ide.core.ast.NotAllowedException;
import org.overture.ide.vdmsl.core.IVdmSlCoreConstants;
import org.overture.pog.obligations.POContextStack;
import org.overture.pog.obligations.ProofObligationList;
import org.overture.pog.visitors.PogVisitor;

public class ViewPosActionSl extends ViewPosAction {

	@Override
	protected String getNature() {
		return IVdmSlCoreConstants.NATURE;
	}

	@Override
	protected ProofObligationList getProofObligations(IVdmModel root) throws NotAllowedException {
		PogVisitor pogVisitor = new PogVisitor();
		ProofObligationList obligations = new ProofObligationList();
		if(!root.isTypeCorrect()){
			return null;
		}
		for (Object definition : root.getModuleList()) {
			if (definition instanceof AModuleModules)
				if (!((AModuleModules) definition).getName().equals("DEFAULT") && skipElement(((AModuleModules) definition).getName().getLocation().file))
					continue;
				else
				{
					ProofObligationList tmp = pogVisitor.caseAModuleModules((AModuleModules) definition,new POContextStack());
					tmp.trivialCheck();
					obligations.addAll(tmp);
				}
		}

		final ProofObligationList pos = obligations;
		return pos;
	}
}
