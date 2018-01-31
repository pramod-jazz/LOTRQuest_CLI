package org.game.fantasy.ui;

import org.game.fantasy.controls.ConsoleController;

public class MiddleTile implements DisplayUnit {

    String tileName;
    
    ConsoleController printer = new ConsoleController();


    public MiddleTile(String tileName) {
        this.tileName = tileName;
    }

    @Override
    public void renderUI(boolean isSameLine) {
    	printer.printToConsole(tileName,isSameLine);
    }
}
