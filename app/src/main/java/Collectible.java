// Collectible.java

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.tmsimple.cosmicalliances.PlayerSpaceship;

public class Collectible implements Collidable { // Implementing Collidable interface
    private Bitmap bitmap;
    private float x;
    private float y;

    public Collectible(Bitmap bitmap, float x, float y) {
        this.bitmap = bitmap;
        this.x = x;
        this.y = y;
    }

    // Implementing methods from Collidable interface
    @Override
    public boolean intersects(PlayerSpaceship spaceship) {
        // Implement intersection logic between collectible and spaceship
        return false;
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }

    public void update() {
        // Update collectible position or any other logic
    }

    public void draw(Canvas canvas, Paint paint) {
        // Draw collectible on canvas
        canvas.drawBitmap(bitmap, x, y, paint);
    }
}
