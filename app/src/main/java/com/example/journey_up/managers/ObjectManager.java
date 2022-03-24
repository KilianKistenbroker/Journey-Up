package com.example.journey_up.managers;

import android.graphics.Canvas;

import com.example.journey_up.Interface.GameInterface;
import com.example.journey_up.objects.MyObjects;

import java.util.ArrayList;

public class ObjectManager implements GameInterface {

    // this is a 2-d array where objects are separated by region/location
    public ArrayList<ArrayList<MyObjects>> objectList;

    public ObjectManager() {
        objectList = new ArrayList<>();
    }

    public void add(MyObjects myObjects, int region) {

        // checks if there is enough space in the arrayList

        if (objectList.size() < region) {
            for (int i = 0; i < region - objectList.size(); i++)
                objectList.add(new ArrayList<>());
        }

        objectList.get(region).add(myObjects);
    }

    private void searchInRegion(int region) {
        // use collision detection logic here, with binary traversal.

        // work is received by 'MyObjects' when collision occurs
    }

    private void drawInRegion(int region) {

        // runs linear time complexity rendering for specific region

        for (int i = 0; i < objectList.get(region).size(); i++) {
            //get objects unique draw instructions
            objectList.get(region).get(i).draw();
        }
    }


    @Override
    public void search() {
        /*
        create a switch statement which uses player's current region/location
        as 'case' for searching in different regions of level.
         */


        // call 'searchInRegion(int region);' for particular region.
    }

    @Override
    public void draw(Canvas canvas) {
        // use switch statement here to draw in specific region.

        // run linear for-loop for drawing objects from arrayList
    }

    @Override
    public void sort() {
        // run merge sort for sorting objects in arrayList for loading a level.

    }

    @Override
    public void timer() {
    }
}
