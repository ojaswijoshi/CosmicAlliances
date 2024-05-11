package com.tmsimple.cosmicalliances;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

public class PowerUp {
    private Bitmap powerUpBitmap;
    private int x, y; // Position of the power-up

    public PowerUp(Bitmap powerUpBitmap, int x, int y) {
        this.powerUpBitmap = powerUpBitmap;
        this.x = x;
        this.y = y;
    }

    public void draw(Canvas canvas, Paint paint) {
        if (powerUpBitmap != null && canvas != null && paint != null) {
            // Draw the power-up bitmap on the canvas
            canvas.drawBitmap(powerUpBitmap, x, y, paint);
        }
    }
}

