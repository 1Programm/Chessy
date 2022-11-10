package com.progrn.projects.chessy.core;

public class MoveInfo {

    public final Position position;
    public final boolean wouldKill;

    public MoveInfo(Position position, boolean wouldKill) {
        this.position = position;
        this.wouldKill = wouldKill;
    }
}
