package ru.dsoccer1980.view;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Console implements View {

    @Override
    public void write(String message) {
        System.out.println(message);
    }

    @Override
    public String read() {
        try {
            Scanner scanner = new Scanner(System.in);
            return scanner.nextLine();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @Override
    public void printField(int[][] field) {
        System.out.print("   1  2  3");
        System.out.println();
        System.out.print("   _  _  _");
        System.out.println();
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (j == 0) System.out.print((i + 1) + "|");
                String symbol = "";
                switch (field[i][j]) {
                    case 1:
                        symbol = "x";
                        break;
                    case 2:
                        symbol = "0";
                        break;
                    case 0:
                    default:
                        symbol = ".";

                }
                System.out.print(" " + symbol + " ");
            }
            System.out.println();
        }
    }
}
