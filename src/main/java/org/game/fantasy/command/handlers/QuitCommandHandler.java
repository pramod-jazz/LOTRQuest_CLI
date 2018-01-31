package org.game.fantasy.command.handlers;

import org.game.fantasy.command.CommandHandler;
import org.game.fantasy.command.params.QuitCommandParams;
import org.game.fantasy.controls.ConsoleController;
import org.game.fantasy.controls.GameController;

public class QuitCommandHandler implements CommandHandler<QuitCommandParams, String>{
	


	@Override
	public String execute(QuitCommandParams params) throws Exception {

		Boolean  verification = ConsoleController.readBoolean("Are tou sure you want to quit? (yes | no ) ?  ");
		if(verification) {
			ConsoleController.printMessageToConsole("Thanks for playing!! You can same middle earth some other day!!");
			GameController.setGameAborted(true);
			System.exit(0);
		}
		
		ConsoleController.printMessageToConsole("You chose to continue! Middle Earrh thanks you for that!!");
		
		return "call Quit";
	}

}
