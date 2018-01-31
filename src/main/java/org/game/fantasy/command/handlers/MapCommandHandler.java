package org.game.fantasy.command.handlers;

import org.game.fantasy.command.CommandHandler;
import org.game.fantasy.command.params.MapCommandParams;
import org.game.fantasy.ui.MiddleTile;

public class MapCommandHandler implements CommandHandler<MapCommandParams, String>{

	@Override
	public String execute(MapCommandParams params) throws Exception {
		new MiddleTile(  "level" + params.getCurrentLevel() +".txt").renderUI(false);
		return "call map";
	}

}
