// Shot.java
package com.tmsimple.cosmicalliances;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Shot {
    private Bitmap shot;
    private int shx, shy;

    public Shot(Context context, int shx, int shy) {
        this.shot = BitmapFactory.decodeResource(context.getResources(), R.drawable.shot); // Assuming you have a 'shot' image resource
        this.shx = shx;
        this.shy = shy;
    }

    public Bitmap getShot() {
        return shot;
    }

    public int getShx() {
        return shx;
    }

    public int getShy() {
        return shy;
    }
}
