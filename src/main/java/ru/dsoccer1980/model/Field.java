package ru.dsoccer1980.model;


public class Field {
    private int[][] field = new int[3][3];
    private boolean gameStatus = false;
    private boolean isFirstPlayer = true;

    public boolean isGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(boolean gameStatus) {
        this.gameStatus = gameStatus;
    }

    public boolean isFirstPlayer() {
        return isFirstPlayer;
    }

    public void setFirstPlayer(boolean firstPlayer) {
        isFirstPlayer = firstPlayer;
    }

    public int[][] getField() {
        return cloneArray(field);
    }

    public void setMove(int x, int y) {
        field[x - 1][y - 1] = isFirstPlayer ? 1 : 2;
    }

    private static int[][] cloneArray(int[][] src) {
        int length = src.length;
        int[][] target = new int[length][src[0].length];
        for (int i = 0; i < length; i++) {
            System.arraycopy(src[i], 0, target[i], 0, src[i].length);
        }
        return target;
    }
}
