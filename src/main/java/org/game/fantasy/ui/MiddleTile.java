package org.game.fantasy.ui;

public class MiddleTile extends ConsolePrinter implements DisplayUnit {

    String tileName;


    public MiddleTile(String tileName) {
        this.tileName = tileName;
    }

    @Override
    public void renderUI() {
        printToConsole(tileName);
    }
}
