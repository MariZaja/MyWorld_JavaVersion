package com.world.animals;

import com.world.Organism;
import com.world.World;

public class Turtle extends Animal{

    public Turtle(World w, int x, int y) {
        super(w, x, y);
        force = 2;
        initiative = 1;
        ID = 8;
    }

    public void action() {
        int moving = rand.nextInt(4);
        if (moving == 0){
            super.action();
        }
    }

    public boolean collision(Organism o) {
        if (o.getForce() < 5){
            return true;
        }
        //return super.collision(o);
        return true;
    }

}
