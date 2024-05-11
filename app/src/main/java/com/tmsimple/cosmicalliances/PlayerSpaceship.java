package com.tmsimple.cosmicalliances;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class PlayerSpaceship {
    private Bitmap bitmap;
    private int x, y; // Position of the spaceship
    private int speed; // Speed of the spaceship

    public PlayerSpaceship(Bitmap bitmap, int x, int y) {
        this.bitmap = bitmap;
        this.x = x;
        this.y = y;
        this.speed = 5; // Set the initial speed of the spaceship
    }

    public void update() {
        // Update the position of the spaceship (always moving forward)
        y -= speed;
    }

    public void draw(Canvas canvas) {
        // Draw the spaceship on the canvas
        canvas.drawBitmap(bitmap, x - (bitmap.getWidth() / 2), y - (bitmap.getHeight() / 2), null);
    }
}
