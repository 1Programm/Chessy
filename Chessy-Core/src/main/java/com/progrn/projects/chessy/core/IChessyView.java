package com.progrn.projects.chessy.core;

public interface IChessyView {

    void start();
    void stop();

    void killPiece(int x, int y);
    void movePiece(int x, int y, int destX, int destY);
    void morphPawn(int x, int y, PieceType pieceType);

    void changeStateToMenu();
    void changeStateToPlay();
    void changeStateToWin(boolean whiteWins);

}
