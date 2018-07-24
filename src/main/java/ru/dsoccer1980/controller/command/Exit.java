package ru.dsoccer1980.controller.command;


import ru.dsoccer1980.view.View;

public class Exit implements Command {
    private View view;

    public Exit(View view) {
        this.view = view;
    }

    @Override
    public boolean canProcess(String command) {
        return command.equals("exit");
    }

    @Override
    public void process(String command) {
        view.write("Bye!");
        throw new ExitException();

    }
}
