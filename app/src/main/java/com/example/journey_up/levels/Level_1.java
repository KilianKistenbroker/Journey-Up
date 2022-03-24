package com.example.journey_up.levels;

import android.graphics.Camera;
import android.graphics.Canvas;

import com.example.journey_up.Interface.GameInterface;

public class Level_1 implements GameInterface {
    /*
     InGameTimerThread -> creates new runnable for counting down.
     SortingThread -> creates new runnable for sorting objects
     CollisionThread -> creates new runnable for collision-detections
     LevelTouchControls -> allows for touch controls for playing levels
     Camera -> allows for screen movement.
     Player -> This is the player object. player.getCurrentRegion() will
                be helpful for searching and drawing in relevant areas.
     FinishLine -> where the player needs to land to complete the level.
     */

    public Level_1() {
        // define the above objects

        // populate the managers arrayLists with objects for player to interact with.

        // run SortingThread.runSort(); must be its own thread that way loading animation remains uninterrupted.
    }

    public void receivedTouch() {}

//    public Camera getCamera() {return camera;}

    //beginLevel() will be called when the start button is pressed from LevelInterface.

    public void beginLevel() {
        /*
         run CollisionThread.runCollision(); must communicate with LevelInterface to determine current state
         of game (i.e. paused, game over, etc...).
         */

        // runs in-game timer thread. Must also communicate with LevelInterface to pause timer when game is paused.
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Canvas canvas) {

    }
}
