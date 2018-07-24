package ru.dsoccer1980.controller.command;


import ru.dsoccer1980.model.Field;
import ru.dsoccer1980.view.View;

public class Start implements Command {
    private Field field;
    private View view;

    public Start(Field field, View view) {
        this.field = field;
        this.view = view;
    }

    @Override
    public boolean canProcess(String command) {
        return (!field.isGameStatus() && command.equals("start"));
    }

    @Override
    public void process(String command) {
        if (!field.isGameStatus()) {
            field.setGameStatus(true);
            view.write("Game has begun:");
            view.printField(field.getField());
        }
    }
}
