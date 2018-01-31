package org.game.fantasy.controls;

import org.game.fantasy.GameContext;
import org.game.fantasy.command.Command;

/**
* The base class for anything.
*/
public abstract class GameControlBase {
    private GameContext gameContext = new GameContext();

    public <ParamType, ReturnType> ReturnType executeCommand(Command<ParamType, ReturnType> command,
            ParamType parameters) throws Exception {
      return getApplicationContext().executeCommand(command, parameters);
    }

    private GameContext getApplicationContext() {
       return gameContext;
    }
}