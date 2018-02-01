package org.game.fantasy.command.handlers;

import org.game.fantasy.command.CommandHandler;
import org.game.fantasy.command.params.ProfileCommandParams;


/**
 * The Class ProfileCommandHandler.
 */
public class ProfileCommandHandler implements CommandHandler<ProfileCommandParams, String> {

	/* (non-Javadoc)
	 * @see org.game.fantasy.command.CommandHandler#execute(java.lang.Object)
	 */
	@Override
	public String execute(ProfileCommandParams params) throws Exception {

		System.out.println("You are " + params.getPlayerName());
		System.out.println("You are at level " + params.getCurrentLevel());
		System.out.println("Your points are : " + params.getCurrentPoint());

		return "call Profile";
	}

}
