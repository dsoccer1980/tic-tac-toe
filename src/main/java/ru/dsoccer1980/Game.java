package ru.dsoccer1980;

import ru.dsoccer1980.controller.MainController;
import ru.dsoccer1980.model.Field;
import ru.dsoccer1980.view.Console;
import ru.dsoccer1980.view.View;

public class Game {
    private static int[][] field = new int[3][3];

    public static void main(String[] args) {
        View view = new Console();
        Field field = new Field();
        MainController controller = new MainController(view, field);
        controller.run();
    }


}
