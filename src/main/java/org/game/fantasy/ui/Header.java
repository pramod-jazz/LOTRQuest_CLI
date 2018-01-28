package org.game.fantasy.ui;

public class Header  implements DisplayUnit{
    String headerFile = "game_header.txt";

    ConsolePrinter printer = new ConsolePrinter();
    
    @Override
    public void renderUI() {

    	printer.printToConsole(headerFile);

    }
}
