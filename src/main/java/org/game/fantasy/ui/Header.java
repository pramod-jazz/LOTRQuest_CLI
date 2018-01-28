package org.game.fantasy.ui;

public class Header extends ConsolePrinter implements DisplayUnit{
    String headerFile = "game_header.txt";

    @Override
    public void renderUI() {

     printToConsole(headerFile);

    }
}
