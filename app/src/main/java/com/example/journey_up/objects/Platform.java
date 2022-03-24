package com.example.journey_up.objects;

import android.graphics.Bitmap;
import android.graphics.Rect;

import java.util.ArrayList;

public class Platform {

    /*
    region will define the objects current location in level.
    UNIT and GROUND will be my units of measurements when scaling
    objects to fit various screen sizes.
     */

    public int region = 0;
    int UNIT;
    int GROUND;

    /*
    l, t, r, b will define if a particular side of Rect platform
    is solid or hollow for the player to collide with.
     */

    Rect platform;
    int left, right, height, l, t, r, b;

    /*
    counter will be used for instructions after player-object collision occurs.
    platformImages will be an array of smaller 1 x 1 Rect objects inside the
    platform for holding images of the platform.
     */

    boolean counter = true;
    ArrayList<Rect> platformImages = new ArrayList<>();

    private static final String TAG = "msg";

    public Platform(int region, int left, int top, int right, int height, int l, int t, int r, int b) {
        this.region = region;
        this.platform = new Rect(region * UNIT * left, GROUND - UNIT * top, region * right,
                GROUND - UNIT * top + UNIT * height);
        this.left = left;
        this.right = right;
        this.height = height;
        this.l = l;
        this.t = t;
        this.r = r;
        this.b = b;

        /*
        the following code populates platformImages with Rect objects for
        the purpose of holding a piece of the platform image. Later on I will
        define logic to place certain bitmaps in certain areas of the platform.
        This allows for bitmaps to be reusable for various platform sizes.
         */

        int xCount = 0;
        int yCount = 0;
        for (int i = 0; i < (right-left) * height; i++) {
            if (xCount == right-left) {
                yCount++;
                xCount = 0;
            }

            platformImages.add(new Rect(platform.left + UNIT * xCount, platform.top + UNIT * yCount,
                    platform.left + UNIT * xCount + UNIT, platform.top + UNIT * yCount + UNIT));
            xCount++;
        }

    }

    public void work() {


    }

    public void draw() {

    }
}
