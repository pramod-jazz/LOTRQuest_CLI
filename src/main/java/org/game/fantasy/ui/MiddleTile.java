package org.game.fantasy.ui;

import org.game.fantasy.controls.ConsoleController;


/**
 * The Class MiddleTile. You can attach as many as you want.
 */
public class MiddleTile implements DisplayUnit {

	/** The tile name. */
	String tileName;

	/** The printer. */
	ConsoleController printer = new ConsoleController();

	/**
	 * Instantiates a new middle tile.
	 *
	 * @param tileName the tile name
	 */
	public MiddleTile(String tileName) {
		this.tileName = tileName;
	}

	/* (non-Javadoc)
	 * @see org.game.fantasy.ui.DisplayUnit#renderUI(boolean)
	 */
	@Override
	public void renderUI(boolean isSameLine) {
		printer.printToConsole(tileName, isSameLine);
	}
}
