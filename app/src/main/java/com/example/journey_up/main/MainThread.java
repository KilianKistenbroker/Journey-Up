package com.example.journey_up.main;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class MainThread extends Thread{
    private final SurfaceHolder surfaceHolder;
    private final GamePanel gamePanel;
    public static Canvas canvas;

    private boolean isRunning = false;

    public void setRunning(boolean running) {
        this.isRunning = running;
    }

    public MainThread(SurfaceHolder surfaceHolder, GamePanel gamePanel) {
        super();
        this.surfaceHolder = surfaceHolder;
        this.gamePanel = gamePanel;
    }

    public void run() {
        double next_game_tick = System.currentTimeMillis();
        int loops;

        while (isRunning) {
            loops = 0;
            canvas = null;

            int MAX_FRAME_SKIP = 5;
            int TICKS_PER_SECOND = 60;
            int SKIP_TICKS = 1000 / TICKS_PER_SECOND;
            while (System.currentTimeMillis() > next_game_tick && loops < MAX_FRAME_SKIP) {
                try {
                    canvas = this.surfaceHolder.lockHardwareCanvas();
                    synchronized (surfaceHolder) {
                        this.gamePanel.update();
                        this.gamePanel.draw(canvas);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (canvas != null) {
                        try {
                            surfaceHolder.unlockCanvasAndPost(canvas);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                next_game_tick += SKIP_TICKS;
                loops++;
            }
        }
    }
}
