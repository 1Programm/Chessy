package com.progen.projects.chessy.engine;

import com.progen.projects.chessy.engine.pieces.Knight;
import com.progen.projects.chessy.engine.pieces.Pawn;
import com.progen.projects.chessy.engine.pieces.Piece;
import com.progrn.projects.chessy.core.Position;
import com.progrn.projects.chessy.core.TeamColor;

public class ChessGame {

    Piece[][] board;


    public static void main(String[] args) {
        //Diese klasse vllt in sowas wie 'ChessyEngine' umwandeln,
        //die zumindest die Methoden start() und setView(IChessyView view) hat
        //und in deiner start() methode muss auch view.start() aufgerufen werden um den JFrame visible zu machen
        ChessGame game = new ChessGame();
        game.board = new Piece[8][8];
        for (int i = 0; i < game.board.length; i++) {
            for (int j = 0; j < game.board[0].length; j++) {
                game.board[i][j] = null;
            }
        }
        game.addPiece(new Pawn(TeamColor.White, Position.createPosition(1, 2)));
        game.addPiece(new Knight(TeamColor.Black, Position.createPosition(0, 3)));

        System.out.println(game.boardToText());
        System.out.println(game.legalMoveInterpreter(1,2,0,3));

    }

    private  void addPiece(Piece piece) {
        board[piece.position.getX()][piece.position.getY()] = piece;
    }

    private  String boardToText() {
        StringBuilder builder = new StringBuilder();

        for (int y = board.length - 1; y >= 0; y--) {
            for (int x = 0; x < board[0].length; x++) {
                if (board[x][y] == null) {
                    builder.append("- ");
                } else {
                    if (board[x][y].color == TeamColor.Black) {
                        builder.append(board[x][y].blackPieceChar).append(" ");
                    } else builder.append(board[x][y].whitePieceChar).append(" ");
                }
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    private  boolean legalMoveInterpreter(int sX, int sY, int gX, int gY) {

        Piece piece = board[sX][sY];
        if(piece == null) {
            System.out.println("Error: Piece is null!");
            return false;
        }
        Position[] poss = piece.getReachablePosition(board);

        for (Position position : poss) {
            if (position.getX() == gX && position.getY() == gY) return true;
        }
        return false;

    }

}
