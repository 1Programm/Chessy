package com.progrn.projects.chessy.core;

public class PositionFactory {

    private final int x;
    private final int y;
    public PositionFactory(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public  Position createPosition(int x, int y) {
        if (!(x >= 0 && x <= this.x)) {
            System.out.println("X Position out of bounds");
            return null;
        }
        if (!(y >= 0 && y <= this.y)) {
            System.out.println("Y Position out of bounds");
            return null;
        }
        return new Position(x, y);
    }
}
