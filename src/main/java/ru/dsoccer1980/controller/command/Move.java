package ru.dsoccer1980.controller.command;


import ru.dsoccer1980.model.Field;
import ru.dsoccer1980.view.View;

public class Move implements Command {
    private Field field;
    private View view;

    public Move(Field field, View view) {
        this.field = field;
        this.view = view;
    }

    @Override
    public boolean canProcess(String command) {
        return (field.isGameStatus() && command.matches("\\d\\s\\d"));
    }

    @Override
    public void process(String command) {
        int x = Integer.valueOf(command.split(" ")[0]);
        int y = Integer.valueOf(command.split(" ")[1]);
        if (!validationField(x, y)) {
            view.write("Wrong move");
            return;
        }
        if (!checkIsFreeField(x, y)) {
            view.write("The cell(" + x + "," + y + ") is busy");
            return;
        }
        field.setMove(x, y);
        field.setFirstPlayer(!field.isFirstPlayer());
        view.printField(field.getField());
    }

    private boolean checkIsFreeField(int x, int y) {
        int value = field.getField()[x - 1][y - 1];
        return (value == 0);
    }

    private boolean validationField(int x, int y) {
        return (x - 1 >= 0) && (x - 1 <= 3) && (y - 1 >= 0) && (y - 1 <= 3);
    }
}
