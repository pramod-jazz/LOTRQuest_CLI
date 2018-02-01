package org.game.fantasy.command.handlers;

import org.game.fantasy.command.CommandHandler;
import org.game.fantasy.command.params.ResumeCommandParams;


/**
 * The Class ResumeCommandHandler.
 */
public class ResumeCommandHandler implements CommandHandler<ResumeCommandParams, String>{

	/* (non-Javadoc)
	 * @see org.game.fantasy.command.CommandHandler#execute(java.lang.Object)
	 */
	@Override
	public String execute(ResumeCommandParams params) throws Exception {
		System.out.println("Yeepy .. I am showing Resume here");
		return "call Resume";
	}

}
