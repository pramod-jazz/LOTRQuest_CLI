package org.game.fantasy.ui;


/**
 * The Interface DisplayUnit.
 * 
 * You can use this class dynamically to attach as many UI tiles as possible.
 */
public interface DisplayUnit {
	
	/**
	 * Render UI.
	 *
	 * @param isSameLine the is same line
	 */
	public void renderUI(boolean isSameLine);
}
