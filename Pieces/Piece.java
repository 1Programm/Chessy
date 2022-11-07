package MoreFunni.Pieces;

import MoreFunni.Position;
import MoreFunni.TeamColor;

public class Piece {

    public TeamColor color;
    public Position position;
    public char blackPieceChar;
    public char whitePieceChar;

    public Piece(TeamColor color, Position position) {
        this.color = color;
        this.position = position;
    }


    public Position[] getReachablePosition(Piece[][] board) {
        return null;
    }
}
