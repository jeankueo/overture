package org.overturetool.ast.itf;

import java.util.*;
import jp.co.csk.vdm.toolbox.VDM.*;

public abstract interface IOmlSetEnumPattern extends IOmlPattern
{
	@SuppressWarnings("rawtypes")
	abstract Vector getPatternList() throws CGException;
}

