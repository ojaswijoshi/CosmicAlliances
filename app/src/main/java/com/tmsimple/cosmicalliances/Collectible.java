package com.tmsimple.cosmicalliances;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Collectible {
    private Bitmap bitmap;
    private int x;
    private int y;
    private int width;
    private int height;

    public Collectible(Bitmap bitmap, int x, int y) {
        this.bitmap = bitmap;
        this.x = x;
        this.y = y;
        this.width = bitmap.getWidth();
        this.height = bitmap.getHeight();
    }

    public void update() {
        // Update collectible position or any other relevant attributes
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

    // Other methods for handling collectible behavior
}
