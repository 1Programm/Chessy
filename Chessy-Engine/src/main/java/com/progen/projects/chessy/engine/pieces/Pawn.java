package com.progen.projects.chessy.engine.pieces;

import com.progrn.projects.chessy.core.PieceType;
import com.progrn.projects.chessy.core.Position;
import com.progrn.projects.chessy.core.TeamColor;

import java.util.ArrayList;

public class Pawn extends Piece {

    public Pawn(TeamColor color, Position position) {
        super(PieceType.PAWN, color, position, 'P', 'p');
        blackPieceChar = 'p';
        whitePieceChar = 'P';
    }

    @Override
    public Position[] getReachablePosition(Piece[][] board) {
        ArrayList<Position> list = new ArrayList<>();
        int dir = color == TeamColor.White ? 1 : -1;

        if (position.getY() == 3.5 - dir * 2.5 && board[position.getX()][position.getY() + dir] == null && board[position.getX()][position.getY() + dir * 2] == null)
            list.add(Position.createPosition(position.getX(), position.getY() + dir * 2));            //Move up 2 from start

        if (position.getY() != 3.5 - dir * 3.5) {
            if (board[position.getX()][position.getY() + dir] == null)
                list.add(Position.createPosition(position.getX(), position.getY() + dir));        //Move up 1


            if (position.getX() != 0 && board[position.getX() - 1][position.getY() + dir] != null && board[position.getX() - 1][position.getY() + dir].color != color)
                list.add(Position.createPosition(position.getX() - 1, position.getY() + dir)); // take left

            if (position.getX() != board.length-1 && board[position.getX() + 1][position.getY() + dir] != null && board[position.getX() + 1][position.getY() + dir].color != color)
                list.add(Position.createPosition(position.getX() + 1, position.getY() + dir)); // take right
        }

        return list.toArray(new Position[0]);
    }
}
