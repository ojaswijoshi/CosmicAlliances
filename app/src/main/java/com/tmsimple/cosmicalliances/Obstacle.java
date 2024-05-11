package com.tmsimple.cosmicalliances;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Obstacle {
    private Bitmap bitmap;
    private int x;
    private int y;
    private int width;
    private int height;

    public Obstacle(Bitmap bitmap, int x, int y, int width, int height) {
        this.bitmap = bitmap;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void update() {
        // Update obstacle position or any other relevant attributes
    }

    public void draw(Canvas canvas, Paint paint) {
        canvas.drawBitmap(bitmap, x, y, paint);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
