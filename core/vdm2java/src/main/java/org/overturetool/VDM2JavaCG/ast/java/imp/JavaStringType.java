// this file is automatically generated by treegen. do not modify!

package org.overturetool.VDM2JavaCG.ast.java.imp;

// import the abstract tree interfaces
import org.overturetool.VDM2JavaCG.ast.java.itf.*;

public class JavaStringType extends JavaType implements IJavaStringType
{
	// private member variable (string)
	private String m_string = new String();

	// public operation to retrieve the embedded private field value
	public String getString()
	{
		return m_string;
	}

	// public operation to set the embedded private field value
	public void setString(String p_string)
	{
		// consistency check (field must be non null!)
		assert(p_string != null);

		// instantiate the member variable
		m_string = p_string;
	}

	// default constructor
	public JavaStringType()
	{
		super();
		m_string = null;
	}

	// auxiliary constructor
	public JavaStringType(
		String p_string
	) {
		super();
		setString(p_string);
	}

	// visitor support
	public void accept(IJavaVisitor pVisitor) { pVisitor.visitStringType(this); }

	// the identity function
	public String identify() { return "JavaStringType"; }
}
