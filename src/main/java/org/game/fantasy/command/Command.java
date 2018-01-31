package org.game.fantasy.command;

import java.io.File;

import org.game.fantasy.command.params.ContinueCommandParams;
import org.game.fantasy.command.params.HelpCommandParams;
import org.game.fantasy.command.params.MapCommandParams;
import org.game.fantasy.command.params.ProfileCommandParams;
import org.game.fantasy.command.params.QuitCommandParams;
import org.game.fantasy.command.params.ResumeCommandParams;

/** the command class defines the interface for a command and has the available commands listed out in my 
* implementation.  The important thing is the interface itself but the Command constants can be located in any 
* class or classes.
*/
public class Command<ParamType, ReturnType> {
    public static final Command<ChooseFileCommandParams, File> CHOOSE_FILE = new Command<ChooseFileCommandParams, File>(
            "Choose File");
    public static final Command<HelpCommandParams, String> HELP = new Command<HelpCommandParams,  String>(
            "This Command is showing you help!");

    public static final Command<MapCommandParams, String> MAP = new Command<MapCommandParams,  String>(
            "This Command is showing you Map!");
    
    public static final Command<ProfileCommandParams, String> PROFILE = new Command<ProfileCommandParams,  String>(
            "This Command is showing you Profile!");
    
    public static final Command<ResumeCommandParams, String> RESUME = new Command<ResumeCommandParams,  String>(
            "This Command is showing you Resume!");
    
    public static final Command<QuitCommandParams, String> QUIT = new Command<QuitCommandParams,  String>(
            "This Command is showing you Quit!");
    
    public static final Command<ContinueCommandParams, String> CONTINUE = new Command<ContinueCommandParams,  String>(
            "This Command is showing you Continue!");


    
    
   /* public static final Command<AnotherCommandParams, String> ANOTHER_COMMAND = new Command<AnotherCommandParams, String>(
            "Another Command");*/

    private String name;

    private Command(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}	