package com.world.plants;

import com.world.Organism;
import com.world.World;

public class Guarana extends Plant{

    public Guarana(World w, int x, int y) {
        super(w, x, y);
        force = 0;
        ID = 2;
        color = 16711807;
        name = "Guarana";
    }

    public boolean collision(Organism o) {
    //    if (o->getID() != HUMAN){ o->forceBoost(3); }
    //    return super.collision(o);
        return true;
    }

}
