package org.game.fantasy.command.handlers;

import org.game.fantasy.command.CommandHandler;
import org.game.fantasy.command.params.QuitCommandParams;
import org.game.fantasy.controls.ConsoleController;


/**
 * The Class QuitCommandHandler.
 */
public class QuitCommandHandler implements CommandHandler<QuitCommandParams, String> {

	/* (non-Javadoc)
	 * @see org.game.fantasy.command.CommandHandler#execute(java.lang.Object)
	 */
	@Override
	public String execute(QuitCommandParams params) throws Exception {

		Boolean verification = ConsoleController.readBoolean("Are tou sure you want to quit? (yes | no ) ?  ");
		if (verification) {
			ConsoleController.printMessageToConsole("Thanks for playing!! You can save middle earth some other day!!");

			System.exit(0);
		}

		ConsoleController.printMessageToConsole("You chose to continue! Middle Earth thanks you for that!!");

		return "call Quit";
	}

}
