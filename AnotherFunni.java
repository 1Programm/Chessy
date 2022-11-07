package MoreFunni;

import MoreFunni.Pieces.Pawn;
import MoreFunni.Pieces.Piece;

public class AnotherFunni {

    static Piece[][] board;


    public static void main(String[] args) {

        board = new Piece[8][8];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = null;
            }
        }
        addPiece(new Pawn(TeamColor.White, Position.createPosition(1, 2)));
        addPiece(new Pawn(TeamColor.Black, Position.createPosition(0, 4)));

        System.out.println(boardToText());
        System.out.println(legalMoveInterpreter(1,2,0,3));


        //startGame();
    }

    private static void startGame() {

        boolean running = true;
        while (running) {


        }
    }

    private static void addPiece(Piece piece) {
        board[piece.position.getX()][piece.position.getY()] = piece;
    }

    private static String boardToText() {
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


    private static boolean legalMoveInterpreter(int sX, int sY, int gX, int gY) {

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


    private static int charToInt(char letter) {

        switch (letter) {
            case 'a':
                return 0;
            case 'b':
                return 1;
            case 'c':
                return 2;
            case 'd':
                return 3;
            case 'e':
                return 4;
            case 'f':
                return 5;
            case 'g':
                return 6;
            case 'h':
                return 7;
        }
        return -1;


    }
}
