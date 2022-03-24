package com.example.journey_up.objects;

public class MyObjects {

    // CHANGE: have unique classes per object

    int id = 0;
    int region = 0;

    int left = 0;
    int top = 0;
    int right = 0;
    int bottom = 0;

    public MyObjects(int id, int region, int left, int top, int right, int bottom) {
        /*
        runs switch-statement with id as 'case' to determine what
        instructions/role to give an object.
         */


    }
    public void work() {
        // will use a switch to find the instruction to execute on player-object collision
        // work is given to the manager

    }

    public void draw() {
        // will also use switch statement to draw specific objects

    }

    /*
    below will be functions of the instructions to execute
     */
    private void platformInstructions(){}

    private void itemInstruction(){}
}
