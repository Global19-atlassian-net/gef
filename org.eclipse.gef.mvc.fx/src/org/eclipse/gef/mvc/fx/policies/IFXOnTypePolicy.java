/*******************************************************************************
 * Copyright (c) 2016 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Matthias Wienand (itemis AG) - initial API and implementation
 *
 *******************************************************************************/
package org.eclipse.gef.mvc.fx.policies;

import org.eclipse.gef.mvc.fx.tools.FXTypeTool;
import org.eclipse.gef.mvc.policies.IPolicy;

import javafx.scene.Node;
import javafx.scene.input.KeyEvent;

/**
 * An interaction policy that implements the {@link IFXOnTypePolicy} interface
 * will be notified about keyboard events by the {@link FXTypeTool}.
 *
 * @author mwienand
 *
 */
public interface IFXOnTypePolicy extends IPolicy<Node> {

	/**
	 * This callback method is invoked when the viewer loses its focus while a
	 * key press/release gesture is running.
	 */
	void abortPress();

	/**
	 * This callback method is invoked when the user releases a key while the
	 * host has keyboard focus.
	 *
	 * @param event
	 *            The original {@link KeyEvent}.
	 */
	void finalRelease(KeyEvent event);

	/**
	 * This callback method is invoked when the user presses a key while the
	 * host has keyboard focus.
	 *
	 * @param event
	 *            The original {@link KeyEvent}.
	 */
	void initialPress(KeyEvent event);

	/**
	 * This callback method is invoked when the user presses a key while a
	 * keyboard gesture is active, i.e. after the initial press (
	 * {@link #initialPress(KeyEvent)}) and before the final release
	 * ({@link #finalRelease(KeyEvent)}).
	 *
	 * @param event
	 *            The original {@link KeyEvent}.
	 */
	void press(KeyEvent event);

	/**
	 * This callback method is invoked when the user releases a key while a
	 * keyboard gesture is active, i.e. after the initial press (
	 * {@link #initialPress(KeyEvent)}) and before the final release
	 * ({@link #finalRelease(KeyEvent)}).
	 *
	 * @param event
	 *            The original {@link KeyEvent}.
	 */
	void release(KeyEvent event);

}