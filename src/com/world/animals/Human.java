package com.world.animals;

import com.world.Organism;
import com.world.World;

public class Human extends Organism {

    protected int direction;

    public Human(World w, int x, int y) {
        super(w, x, y);
        color = 15060223;
        initiative = 4;
    }

    public void setDirection(int d) {
        direction = d;
        System.out.println("Direction set");
        System.out.println(direction);
    }

}
