package com.example.journey_up.main;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {

    //mainThread will run draw() and update() in synchronization.
    private MainThread mainThread;

    //insert new InternalClock here. This is its own thread, and will contain children of in-game countdown threads.

    public GamePanel (Context context) {
        super(context);
        getHolder().addCallback(this);
        Constants.CURRENT_CONTEXT = context;
        mainThread = new MainThread(getHolder(), this);
        // insert a sceneManager here

        setFocusable(true);
        getHolder().setFixedSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        mainThread = new MainThread(getHolder(), this);
        Constants.TIME = System.currentTimeMillis();
        mainThread.setRunning(true);
        mainThread.start();

        // insert persistence here to get saved data on create

        // insert InternalClock.start(), after getting user saved data
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return true;
    }

    public void update() {
        // update from a sceneManager
    }

    @Override
    public void draw(Canvas canvas) {
        if (canvas != null) {
            super.draw(canvas);
            // draw from a sceneManager

        }
        else {
            mainThread.setRunning(false);
        }
    }
}
