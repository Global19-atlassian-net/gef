/*******************************************************************************
 * Copyright (c) 2016 itemis AG and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Tamas Miklossy (itemis AG) - initial API and implementation (bug #498324)
 *******************************************************************************/
package org.eclipse.gef.dot.internal.parser.ui.contentassist;

import org.eclipse.gef.dot.internal.parser.arrowtype.DeprecatedShape;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;

/**
 * See
 * https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#content-assist
 * on how to customize the content assistant.
 */
public class DotArrowTypeProposalProvider extends
		org.eclipse.gef.dot.internal.parser.ui.contentassist.AbstractDotArrowTypeProposalProvider {

	@Override
	protected ICompletionProposal createCompletionProposal(String proposal,
			StyledString displayString, Image image, int priority,
			String prefix, ContentAssistContext context) {

		for (DeprecatedShape deprecatedShape : DeprecatedShape.VALUES) {
			if (deprecatedShape.toString().equals(proposal)) {
				// don't propose the deprecated shapes
				return null;
			}
		}

		return super.createCompletionProposal(proposal, displayString, image,
				priority, prefix, context);
	}
}
