package org.game.fantasy.ui;

import org.game.fantasy.controls.ConsoleController;

public class Header  implements DisplayUnit{
    String headerFile = "game_header.txt";

    ConsoleController printer = new ConsoleController();
    
    @Override
    public void renderUI( boolean isSameLine ) {

    	printer.printToConsole(headerFile,isSameLine);

    }
}
