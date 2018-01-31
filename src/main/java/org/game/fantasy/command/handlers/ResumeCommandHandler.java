package org.game.fantasy.command.handlers;

import org.game.fantasy.command.CommandHandler;
import org.game.fantasy.command.params.ResumeCommandParams;

public class ResumeCommandHandler implements CommandHandler<ResumeCommandParams, String>{

	@Override
	public String execute(ResumeCommandParams params) throws Exception {
		System.out.println("Yeepy .. I am showing Resume here");
		return "call Resume";
	}

}
