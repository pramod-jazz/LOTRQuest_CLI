package org.game.fantasy.command.handlers;

import org.game.fantasy.command.CommandHandler;
import org.game.fantasy.command.params.HelpCommandParams;
import org.game.fantasy.ui.MiddleTile;

public class HelpCommandHandler implements CommandHandler<HelpCommandParams, String>{

	@Override
	public String execute(HelpCommandParams params) throws Exception {
		new MiddleTile( "help.txt").renderUI(false);
		return "call success";
	}

}
