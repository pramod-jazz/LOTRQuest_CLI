package org.game.fantasy.command.handlers;

import org.game.fantasy.command.CommandHandler;
import org.game.fantasy.command.params.ProfileCommandParams;
import org.game.fantasy.dao.LevelDAO;

public class ProfileCommandHandler implements CommandHandler<ProfileCommandParams, String>{

	@Override
	public String execute(ProfileCommandParams params) throws Exception {
		LevelDAO levelDAO = new LevelDAO();
		
		        
		System.out.println("You are " + params.getPlayerName() );
		System.out.println("You are at level " + params.getCurrentLevel() );
		System.out.println("Your points are : " + params.getCurrentPoint());
		
		return "call Profile";
	}

}
