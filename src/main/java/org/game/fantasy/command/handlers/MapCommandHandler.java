package org.game.fantasy.command.handlers;

import org.game.fantasy.command.CommandHandler;
import org.game.fantasy.command.params.MapCommandParams;
import org.game.fantasy.ui.MiddleTile;


/**
 * The Class MapCommandHandler.
 */
public class MapCommandHandler implements CommandHandler<MapCommandParams, String> {

	/* (non-Javadoc)
	 * @see org.game.fantasy.command.CommandHandler#execute(java.lang.Object)
	 */
	@Override
	public String execute(MapCommandParams params) throws Exception {
		new MiddleTile("level" + params.getCurrentLevel() + ".txt").renderUI(false);
		return "call map";
	}

}
