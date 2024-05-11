package com.tmsimple.cosmicalliances;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class GameThread extends Thread {
    private SurfaceHolder surfaceHolder;
    private GameView gameView;
    private boolean running; // Declare the 'running' variable here
    private boolean surfaceCreated = false; // Flag to track surface creation
    private int fps = 30; // Adjust the desired frames per second here

    public GameThread(SurfaceHolder surfaceHolder, GameView gameView) {
        this.surfaceHolder = surfaceHolder;
        this.gameView = gameView;
        this.running = false; // Initialize the 'running' variable
    }

    public void setRunning(boolean isRunning) {
        running = isRunning;
    }

    public void setSurfaceCreated(boolean surfaceCreated) {
        this.surfaceCreated = surfaceCreated;
    }

    @Override
    public void run() {
        while (running) {
            long startTime = System.nanoTime();
            Canvas canvas = null;

            try {
                canvas = surfaceHolder.lockCanvas();
                synchronized (surfaceHolder) {
                    if (canvas != null) {
                        if (!surfaceCreated) {
                            gameView.surfaceCreated(surfaceHolder);
                            surfaceCreated = true;
                        }
                        gameView.update();
                        gameView.draw(canvas);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (canvas != null) {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }

            long elapsedTime = (System.nanoTime() - startTime) / 1000000; // Time taken to process frame in milliseconds
            long sleepTime = Math.max(0, (1000 / fps) - elapsedTime); // Calculate sleep time to achieve desired frame rate

            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
