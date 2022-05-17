package com.world.animals;

import com.world.Organism;
import com.world.World;

public abstract class Animal extends Organism {

    public Animal(World w, int x, int y) {
        super(w, x, y);
    }

    public void action() {
        setDestination(1);
        //if (world.checkPosition(toX, toY)){
        //    world.move(this->organismX, this->organismY, toX, toY);
        //}
    }

}
