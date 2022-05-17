package com.world.animals;

import com.world.World;

public class Wolf extends Animal{

    public Wolf(World w, int x, int y) {
        super(w, x, y);
        force = 9;
        initiative = 5;
        ID = 5;
        color = 8421504;
        name = "Wolf";
    }

}
