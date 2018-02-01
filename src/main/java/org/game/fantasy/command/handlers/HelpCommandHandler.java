package org.game.fantasy.command.handlers;

import org.game.fantasy.command.CommandHandler;
import org.game.fantasy.command.params.HelpCommandParams;
import org.game.fantasy.ui.MiddleTile;


/**
 * The Class HelpCommandHandler.
 */
public class HelpCommandHandler implements CommandHandler<HelpCommandParams, String> {

	/* (non-Javadoc)
	 * @see org.game.fantasy.command.CommandHandler#execute(java.lang.Object)
	 */
	@Override
	public String execute(HelpCommandParams params) throws Exception {
		new MiddleTile("help.txt").renderUI(false);
		return "call success";
	}

}
