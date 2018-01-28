package org.game.fantasy.ui;

public class MiddleTile implements DisplayUnit {

    String tileName;
    
    ConsolePrinter printer = new ConsolePrinter();


    public MiddleTile(String tileName) {
        this.tileName = tileName;
    }

    @Override
    public void renderUI() {
    	printer.printToConsole(tileName);
    }
}
