package com.world.plants;

import com.world.World;

public class Dandelion extends Plant{

    public Dandelion(World w, int x, int y) {
        super(w, x, y);
        force = 0;
        ID = 1;
        color = 16777011;
        name = "Dandelion";
    }

    public void action() {
        int trySpreading=3;
        for (int i=0; i<trySpreading; i++){
            super.action();
        }
    }

}
