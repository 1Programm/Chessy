package com.progen.projects.chessy.engine.pieces;

import com.progrn.projects.chessy.core.PieceType;
import com.progrn.projects.chessy.core.Position;
import com.progrn.projects.chessy.core.TeamColor;

import java.util.ArrayList;

public class Knight extends Piece {
    public Knight(TeamColor color, Position position) {
        super(PieceType.KNIGHT, color, position, 'N', 'n');
    }


    @Override
    public Position[] getReachablePosition(Piece[][] board) {
        ArrayList<Position> list = new ArrayList<>();
        int[] delta = {2, 1, -2, -1, 2, -1, -2, 1, 2}; //Cool Array

        for (int i = 0; i < 8; i++) { // 8 because Knight has to check 8 Tiles
            if (checkTile(board, position.getX() + delta[i], position.getY() + delta[i + 1]))
                list.add(Position.createPosition(position.getX() + delta[i], position.getY() + delta[i + 1]));
        }

        return list.toArray(new Position[0]);
    }

    private boolean checkTile(Piece[][] board, int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length && (board[x][y] == null || board[x][y].color != color);
    }
}
