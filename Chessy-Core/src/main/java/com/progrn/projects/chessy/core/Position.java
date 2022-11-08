package com.progrn.projects.chessy.core;

public class Position {

    private int x, y;

    private Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static Position createPosition(int x, int y) {
        if (!(x >= 0 && x <= 7)) {
            System.out.println("X Position out of bounds");
            return null;
        }
        if (!(y >= 0 && y <= 7)) {
            System.out.println("Y Position out of bounds");
            return null;
        }
        return new Position(x, y);
    }
}
