package com.example.journey_up.managers;

import android.graphics.Canvas;

import com.example.journey_up.Interface.GameInterface;
import com.example.journey_up.objects.Platform;

import java.util.ArrayList;

public class PlatformManager {

    // this is a 2-d array where objects are separated by region/location
    ArrayList<ArrayList<Platform>> platformList;
    Platform platform;

    PlatformManager() {
        platformList = new ArrayList<>();
    }

    // region starts at 1, so I will have to subtract 1 to convert to indexing

    public void add(Platform platform) {
        int indexedRegion = platform.region-1;

        // checks if there is enough space in the arrayList

        if (platformList.size() < indexedRegion + 1) {
            for (int i = 0; i < indexedRegion - platformList.size(); i++)
                platformList.add(new ArrayList<>());
        }

        platformList.get(indexedRegion).add(platform);
    }

    private void searchInRegion(int region) {
        int indexedRegion = region-1;

        // use region to determine which index of platformList to search in.

        // use collision detection logic here, with binary traversal.

        // receive work from 'Platform' when collision occurs.
    }

    private void drawInRegion(int region) {
        int indexedRegion = region-1;

        // use region to determine which index of platformList to search in.

        // runs linear time complexity for rendering in specific region.

        for (int i = 0; i < platformList.get(region).size(); i++) {
            //get objects unique draw instructions
            platformList.get(region).get(i).draw();
        }
    }

    public void sort() {
        // run merge sort for sorting objects in arrayList for loading a level.

    }
}
