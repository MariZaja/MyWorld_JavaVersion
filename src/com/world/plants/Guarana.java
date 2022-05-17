package com.world.plants;

import com.world.Organism;
import com.world.World;
import com.world.animals.Human;

public class Guarana extends Plant{

    public Guarana(World w, int x, int y) {
        super(w, x, y);
        force = 0;
        ID = 2;
        color = 16711807;
        name = "Guarana";
    }

    public boolean collision(Organism o) {
        if (!(o instanceof Human)){ o.forceBoost(3); }
        return super.collision(o);
    }

}
