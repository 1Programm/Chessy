package com.progrn.projects.chessy.core;

/**
 * This class will be passed into IChessyView.start() and will be used by the ui to call certain actions on a mouse press / key press / ...
 */
public interface IChessyController {

    /**
     * The UI will call this method when the player clicked a chess piece and the ui wants to draw the possible fields where the player can place their piece
     * MoveInfo has a position and a boolean which specifies if that move would kill a piece of the enemy.
     */
    MoveInfo[] getValidPositions(int x, int y);

    /**
     * The UI will call this method to tell the engine that the user moved some piece to a new position.
     * This method will also be used when killing enemy pieces.
     */
    void moved(Position prevPosition, Position newPosition);

    /**
     * Player pressed button to give up :D
     */
    void giveUp();

}
