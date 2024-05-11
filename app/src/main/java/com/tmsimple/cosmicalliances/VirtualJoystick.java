package com.tmsimple.cosmicalliances;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class VirtualJoystick extends View {
    private Bitmap background;
    private Bitmap knob;
    private float centerX, centerY; // Center coordinates of the joystick
    private float knobX, knobY; // Current position of the joystick knob

    public VirtualJoystick(Context context, AttributeSet attrs) {
        super(context, attrs);
        // Load joystick graphics
        background = BitmapFactory.decodeResource(context.getResources(), R.drawable.joystick_background_img);
        knob = BitmapFactory.decodeResource(context.getResources(), R.drawable.joystick_knob_img);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        // Calculate initial positions when the size changes
        centerX = w / 2;
        centerY = h / 2;
        knobX = centerX;
        knobY = centerY;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // Draw joystick background
        canvas.drawBitmap(background, centerX - background.getWidth() / 2, centerY - background.getHeight() / 2, null);
        // Draw joystick knob
        canvas.drawBitmap(knob, knobX - knob.getWidth() / 2, knobY - knob.getHeight() / 2, null);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float touchX = event.getX();
        float touchY = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                // Calculate distance from center to touch position
                float dx = touchX - centerX;
                float dy = touchY - centerY;
                float distance = (float) Math.sqrt(dx * dx + dy * dy);
                // If touch is within joystick range, update knob position
                if (distance <= background.getWidth() / 2) {
                    knobX = touchX;
                    knobY = touchY;
                } else {
                    // Calculate angle from center to touch position
                    float angle = (float) Math.atan2(dy, dx);
                    // Limit knob position to joystick range
                    knobX = centerX + (float) (Math.cos(angle) * background.getWidth() / 2);
                    knobY = centerY + (float) (Math.sin(angle) * background.getHeight() / 2);
                }
                invalidate(); // Redraw the view
                break;
        }
        return true;
    }
}
