package org.game.fantasy.ui;

import org.game.fantasy.controls.ConsoleController;


/**
 * This is a useful header Tile to show game banner.
 * The Class Header.
 */
public class Header implements DisplayUnit {
	
	/** The header file. */
	String headerFile = "game_header.txt";

	/** The printer. */
	ConsoleController printer = new ConsoleController();

	/* (non-Javadoc)
	 * @see org.game.fantasy.ui.DisplayUnit#renderUI(boolean)
	 */
	@Override
	public void renderUI(boolean isSameLine) {

		printer.printToConsole(headerFile, isSameLine);

	}
}
