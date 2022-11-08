package com.progen.projects.chessy.engine.pieces;

import com.progrn.projects.chessy.core.PieceType;
import com.progrn.projects.chessy.core.Position;
import com.progrn.projects.chessy.core.TeamColor;

public class Piece {

    public PieceType type;
    public TeamColor color;
    public Position position;
    public char blackPieceChar;
    public char whitePieceChar;

    public Piece(PieceType type, TeamColor color, Position position) {
        this.color = color;
        this.position = position;
    }


    public Position[] getReachablePosition(Piece[][] board) {
        return null;
    }
}
