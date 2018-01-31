package org.game.fantasy.command;

public class CommandHandlerBinding<ParamType, ReturnType> {
    private Command<ParamType, ReturnType> command;

    private CommandHandler<ParamType, ReturnType> handler;

    public CommandHandlerBinding(Command<ParamType, ReturnType> command, CommandHandler<ParamType, ReturnType> handler) {
        this.command = command;
        this.handler = handler;
    }

    public Command<ParamType, ReturnType> getCommand() {
        return command;
    }

    public CommandHandler<ParamType, ReturnType> getHandler() {
        return handler;
    }
}