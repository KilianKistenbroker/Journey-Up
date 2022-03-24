package com.example.journey_up.main;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.Nullable;

public class MainActivity extends Activity {

    // TAG is used writing information to the console for debugging
    public static final String TAG = "msg";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // load in users preferred language

        /*
        The following code will scale down the resolution to approximately
        720 px if the user's phone has a higher resolution. This will help
        maintain a locked 60 fps, since smaller bitmaps will be rendered.
         */

        if (getResources().getDisplayMetrics().widthPixels >= 1440) {
            Constants.DIVISOR = 2;
            Constants.SCREEN_WIDTH = (int) (getResources().getDisplayMetrics().widthPixels/2);
            Constants.SCREEN_HEIGHT = (int) (getResources().getDisplayMetrics().heightPixels/2);
        } else if (getResources().getDisplayMetrics().widthPixels >= 1080) {
            Constants.DIVISOR = 1.5;
            Constants.SCREEN_WIDTH = (int) (getResources().getDisplayMetrics().widthPixels/1.5);
            Constants.SCREEN_HEIGHT = (int) (getResources().getDisplayMetrics().heightPixels/1.5);
        } else {
            Constants.DIVISOR = 1;
            Constants.SCREEN_WIDTH = getResources().getDisplayMetrics().widthPixels;
            Constants.SCREEN_HEIGHT = getResources().getDisplayMetrics().heightPixels;
        }

        /*
        the following code will setup the window to be displayed to the user.
        Calling FLAG_HARDWARE_ACCELERATED will allow the user's GPU to handle
        the rendering/graphics. This will help maintain a locked 60 FPS by taking
        stress off the CPU.
         */

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED, WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        Log.e(TAG, Constants.SCREEN_WIDTH + " " + Constants.SCREEN_HEIGHT + " " );
        Log.e(TAG, getResources().getDisplayMetrics().widthPixels + " " + getResources().getDisplayMetrics().heightPixels);
        setContentView(new GamePanel(this));
    }
}
