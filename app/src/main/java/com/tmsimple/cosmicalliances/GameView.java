package com.tmsimple.cosmicalliances;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    private static final String TAG = "GameView";

    private GameThread gameThread;
    private PlayerSpaceship playerSpaceship;
    private boolean playerSpaceshipCreated = false;

    public GameView(Context context) {
        super(context);
        init(context);
    }

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        // Initialize the surface holder and add callback
        getHolder().addCallback(this);

        // Initialize the game thread
        gameThread = new GameThread(getHolder(), this);

        // Set focusable to true for handling touch events
        setFocusable(true);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        // Create the player spaceship when the surface is created
        playerSpaceship = new PlayerSpaceship(BitmapFactory.decodeResource(getResources(), R.drawable.rocket), getWidth() / 2, getHeight() - 100);
        playerSpaceshipCreated = true;
        gameThread.setRunning(true);
        gameThread.start();
        Log.d(TAG, "Surface created");
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        // Not implemented in this example
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        // Stop the game thread when the surface is destroyed
        boolean retry = true;
        while (retry) {
            try {
                gameThread.setRunning(false);
                gameThread.join();
                retry = false;
            } catch (InterruptedException e) {
                Log.e(TAG, "Error stopping the game thread", e);
            }
        }
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (playerSpaceshipCreated) {
            playerSpaceship.draw(canvas);
        }
    }

    public void update() {
        // Update the player spaceship
        if (playerSpaceshipCreated) {
            playerSpaceship.update();
        }
    }
}
