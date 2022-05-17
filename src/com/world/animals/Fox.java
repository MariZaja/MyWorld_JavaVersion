package com.world.animals;

import com.world.World;

public class Fox extends Animal{

    public Fox(World w, int x, int y) {
        super(w, x, y);
        force = 3;
        initiative = 7;
        ID = 7;
        color = 16744448;
        name = "Fox";
    }

    public void action() {
        setDestination(1);
        int to = (toX)*world.getWorldY()+(toY);
        if (world.checkPosition(toX, toY)){
            if(world.organisms[to] == null || world.organisms[to].getForce() <= this.getForce()){
                world.move(this.organismX, this.organismY, toX, toY);
            }
        }
    }

}
