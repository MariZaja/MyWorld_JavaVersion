package com.world.animals;

import com.world.World;

public class Sheep extends Animal{

    public Sheep(World w, int x, int y) {
        super(w, x, y);
        force = 4;
        initiative = 4;
        ID = 6;
        color = 3381759;
        name = "Sheep";
    }

}
