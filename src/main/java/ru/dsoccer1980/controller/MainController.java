package ru.dsoccer1980.controller;

import ru.dsoccer1980.controller.command.*;
import ru.dsoccer1980.model.Field;
import ru.dsoccer1980.view.View;

public class MainController {
    private final Command[] commands;
    private Field field;
    private View view;

    public MainController(View view, Field field) {
        this.view = view;
        commands = new Command[]{
                new Start(field, view),
                new Move(field, view),
                new Exit(view),
                new Unsupported(view)};
        this.field = field;
    }

    public void run() {
        try {
            doWork();
        } catch (ExitException e) {
            //do nothing
        }
    }

    private void doWork() {
        view.write("Hi players");
        view.write("Type 'start' for game start");

        while (true) {
            String input = view.read();

            for (Command command : commands) {
                try {
                    if (command.canProcess(input)) {
                        command.process(input);
                        break;
                    }
                } catch (Exception e) {
                    if (e instanceof ExitException) {
                        return;
                    }
                    printError(e);
                    break;
                }
            }
            if (field.isGameStatus()) {
                view.write("Your move, the player" + (field.isFirstPlayer() ? 1 : 2) + ":");
            } else {
                view.write("Type command or help:");
            }
        }
    }

    private void printError(Exception e) {
        String message = e.getMessage();
        if (e.getCause() != null)
            message += e.getCause().getMessage();
        view.write("Fail because of:" + message);
        view.write("Try again.");
    }
}
