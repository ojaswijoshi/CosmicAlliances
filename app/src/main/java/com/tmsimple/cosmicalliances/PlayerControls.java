package com.tmsimple.cosmicalliances;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

public class PlayerControls implements OnKeyListener {
    private boolean upPressed;
    private boolean downPressed;
    private boolean leftPressed;
    private boolean rightPressed;

    public PlayerControls() {
        // Initialize key states
        upPressed = false;
        downPressed = false;
        leftPressed = false;
        rightPressed = false;
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_UP:
                upPressed = (event.getAction() == KeyEvent.ACTION_DOWN);
                return true;
            case KeyEvent.KEYCODE_DPAD_DOWN:
                downPressed = (event.getAction() == KeyEvent.ACTION_DOWN);
                return true;
            case KeyEvent.KEYCODE_DPAD_LEFT:
                leftPressed = (event.getAction() == KeyEvent.ACTION_DOWN);
                return true;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                rightPressed = (event.getAction() == KeyEvent.ACTION_DOWN);
                return true;
            default:
                return false;
        }
    }

    // Getter methods for key states
    public boolean isUpPressed() {
        return upPressed;
    }

    public boolean isDownPressed() {
        return downPressed;
    }

    public boolean isLeftPressed() {
        return leftPressed;
    }

    public boolean isRightPressed() {
        return rightPressed;
    }
}
