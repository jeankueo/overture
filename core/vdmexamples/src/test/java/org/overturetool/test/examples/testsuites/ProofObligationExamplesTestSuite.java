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
package org.overturetool.test.examples.testsuites;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.overturetool.test.examples.ProofObligationPpTestCase;
import org.overturetool.test.examples.ProofObligationRtTestCase;
import org.overturetool.test.examples.ProofObligationSlTestCase;
import org.overturetool.test.framework.BaseTestSuite;


public class ProofObligationExamplesTestSuite extends BaseTestSuite
{
	public static Test suite() throws IllegalArgumentException, SecurityException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, IOException
	{
		String name = "Proof Obligation Examples TestSuite";
		String root = "../../documentation/examples/";
		TestSuite test = createTestCompleteDirectory(name,root+"VDM++",ProofObligationPpTestCase.class);
		add(test,createTestCompleteDirectory(name,root+"VDMSL",ProofObligationSlTestCase.class));
		add(test,createTestCompleteDirectory(name,root+"VDMRT",ProofObligationRtTestCase.class));
		return test;
	}

	private static void add(TestSuite test, TestSuite test2)
	{
		@SuppressWarnings("unchecked")
		Enumeration<Test> e = test2.tests();
		while(e.hasMoreElements())
		{
			test.addTest(e.nextElement());
		}
	}
	
	
}
