package ru.dsoccer1980.controller.command;


import ru.dsoccer1980.view.View;

public class Unsupported implements Command {
    private View view;

    public Unsupported(View view) {
        this.view = view;
    }

    @Override
    public boolean canProcess(String command) {
        return true;
    }

    @Override
    public void process(String command) {
        view.write("Unsupported command:" + command);
    }
}
