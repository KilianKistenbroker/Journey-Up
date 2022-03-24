package com.example.journey_up.main;

import android.annotation.SuppressLint;
import android.content.Context;

public class Constants {

    // SCREEN_WIDTH and SCREEN_HEIGHT represent the actual dimensions of the users phone.
    public static int SCREEN_WIDTH;
    public static int SCREEN_HEIGHT;

    // will be used to scale down px density of drawn objects.
    public static double DIVISOR = 1;

    @SuppressLint("StaticFieldLeak")
    public static Context CURRENT_CONTEXT;

    public static long TIME;
}
