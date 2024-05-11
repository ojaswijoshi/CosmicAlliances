// Explosion.java
package com.tmsimple.cosmicalliances;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Explosion {
    private Bitmap[] explosionFrames;
    private int explosionFrame;
    private int eX, eY;

    public Explosion(Context context, int eX, int eY) {
        explosionFrames = new Bitmap[9];
        explosionFrames[0] = BitmapFactory.decodeResource(context.getResources(), R.drawable.explosion0);
        // Load other explosion frames similarly
        this.explosionFrame = 0;
        this.eX = eX;
        this.eY = eY;
    }

    public Bitmap getExplosionFrame() {
        return explosionFrames[explosionFrame];
    }

    public int geteX() {
        return eX;
    }

    public int geteY() {
        return eY;
    }

    public void updateExplosionFrame() {
        explosionFrame++;
    }

    public boolean isComplete() {
        return explosionFrame >= explosionFrames.length;
    }
}
