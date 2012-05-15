/*******************************************************************************
 *
 *	Copyright (c) 2008 Fujitsu Services Ltd.
 *
 *	Author: Nick Battle
 *
 *	This file is part of VDMJ.
 *
 *	VDMJ is free software: you can redistribute it and/or modify
 *	it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *
 *	VDMJ is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *
 *	You should have received a copy of the GNU General Public License
 *	along with VDMJ.  If not, see <http://www.gnu.org/licenses/>.
 *
 ******************************************************************************/

package org.overturetool.vdmj.syntax;

import java.util.List;
import java.util.Vector;

import org.overture.ast.factory.AstFactory;
import org.overture.ast.patterns.PPattern;
import org.overturetool.vdmj.lex.LexBooleanToken;
import org.overturetool.vdmj.lex.LexCharacterToken;
import org.overturetool.vdmj.lex.LexException;
import org.overturetool.vdmj.lex.LexIdentifierToken;
import org.overturetool.vdmj.lex.LexIntegerToken;
import org.overturetool.vdmj.lex.LexKeywordToken;
import org.overturetool.vdmj.lex.LexNameToken;
import org.overturetool.vdmj.lex.LexQuoteToken;
import org.overturetool.vdmj.lex.LexRealToken;
import org.overturetool.vdmj.lex.LexStringToken;
import org.overturetool.vdmj.lex.LexToken;
import org.overturetool.vdmj.lex.LexTokenReader;
import org.overturetool.vdmj.lex.VDMToken;

/**
 * A syntax analyser to parse pattern definitions.
 */

public class PatternReader extends SyntaxReader
{
	public PatternReader(LexTokenReader reader)
	{
		super(reader);
	}

	public PPattern readPattern() throws ParserException, LexException
	{
		PPattern pattern = readSimplePattern();

		while (lastToken().is(VDMToken.UNION)
				|| lastToken().is(VDMToken.CONCATENATE))
		{
			LexToken token = lastToken();

			switch (token.type)
			{
				case UNION:
					nextToken();
					pattern = AstFactory.newAUnionPattern(pattern, token.location, readPattern());
					break;

				case CONCATENATE:
					nextToken();
					pattern = AstFactory.newAConcatenationPattern(pattern, token.location, readPattern());
					break;
			}
		}

		return pattern;
	}

	private PPattern readSimplePattern() throws ParserException, LexException
	{
		PPattern pattern = null;
		LexToken token = lastToken();
		boolean rdtok = true;

		switch (token.type)
		{
			case NUMBER:
				pattern = AstFactory.newAIntegerPattern((LexIntegerToken)token);
				break;

			case REALNUMBER:
				pattern = AstFactory.newARealPattern((LexRealToken) token);
				break;

			case CHARACTER:
				pattern = AstFactory.newACharacterPattern((LexCharacterToken) token);
				break;

			case STRING:
				pattern = AstFactory.newAStringPattern((LexStringToken) token);
				break;

			case QUOTE:
				pattern = AstFactory.newAQuotePattern((LexQuoteToken) token);
				break;

			case TRUE:
			case FALSE:
				pattern = AstFactory.newABooleanPattern((LexBooleanToken) token);
				break;

			case NIL:
				pattern = AstFactory.newANilPattern((LexKeywordToken)token);
				break;

			case BRA:
				nextToken();
				ExpressionReader expr = getExpressionReader();
				pattern = AstFactory.newAExpressionPattern(expr.readExpression() );
				checkFor(VDMToken.KET, 2180, "Mismatched brackets in pattern");
				rdtok = false;
				break;

			case SET_OPEN:
				if (nextToken().is(VDMToken.SET_CLOSE))
				{
					pattern = AstFactory.newASetPattern(token.location, new Vector<PPattern>());
				} else
				{
					pattern = AstFactory.newASetPattern(token.location, readPatternList());
					checkFor(VDMToken.SET_CLOSE, 2181, "Mismatched braces in pattern");
					rdtok = false;
				}
				break;

			case SEQ_OPEN:
				if (nextToken().is(VDMToken.SEQ_CLOSE))
				{
					pattern = AstFactory.newASeqPattern(token.location, new Vector<PPattern>());
				} else
				{
					pattern = AstFactory.newASeqPattern(token.location, readPatternList());
					checkFor(VDMToken.SEQ_CLOSE, 2182, "Mismatched square brackets in pattern");
					rdtok = false;
				}
				break;

			case NAME:
				throwMessage(2056, "Cannot use module'id name in patterns");
				break;

			case IDENTIFIER:
				LexIdentifierToken id = lastIdToken();

				if (id.name.startsWith("mk_"))
				{
					nextToken();

					if (id.name.equals("mk_"))
					{
						checkFor(VDMToken.BRA, 2183, "Expecting '(' after mk_ tuple");
						pattern = AstFactory.newATuplePattern(token.location, readPatternList());
						checkFor(VDMToken.KET, 2184, "Expecting ')' after mk_ tuple");
					} else
					{
						checkFor(VDMToken.BRA, 2185, "Expecting '(' after "
								+ id + " record");
						LexNameToken typename = null;
						int backtick = id.name.indexOf('`');

						if (backtick >= 0)
						{
							// Strange case of "mk_MOD`name"
							String mod = id.name.substring(3, backtick);
							String name = id.name.substring(backtick + 1);
							typename = new LexNameToken(mod, name, id.location);
						} else
						{
							// Regular case of "mk_Name"
							LexIdentifierToken type = new LexIdentifierToken(id.name.substring(3), false, id.location);
							typename = idToName(type);
						}

						if (lastToken().is(VDMToken.KET))
						{
							// An empty pattern list
							pattern = AstFactory.newARecordPattern(typename, new Vector<PPattern>());
							nextToken();
						} else
						{
							pattern = AstFactory.newARecordPattern(typename, readPatternList());
							checkFor(VDMToken.KET, 2186, "Expecting ')' after "
									+ id + " record");
						}
					}

					rdtok = false;
				} else
				{
					pattern = AstFactory.newAIdentifierPattern(idToName(id));
				}
				break;

			case MINUS:
				pattern = AstFactory.newAIgnorePattern(token.location);
				break;

			default:
				throwMessage(2057, "Unexpected token in pattern");
		}

		if (rdtok)
			nextToken();
		return pattern;
	}

	public List<PPattern> readPatternList() throws ParserException,
			LexException
	{
		List<PPattern> list = new Vector<PPattern>();
		list.add(readPattern());

		while (ignore(VDMToken.COMMA))
		{
			list.add(readPattern());
		}

		return list;
	}
}
