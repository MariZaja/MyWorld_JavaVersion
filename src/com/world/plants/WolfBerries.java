package com.world.plants;

import com.world.Organism;
import com.world.World;
import com.world.animals.Animal;

public class WolfBerries extends Plant{

    public WolfBerries(World w, int x, int y) {
        super(w, x, y);
        force = 99;
        ID = 3;
        color = 3342438;
        name = "Wolf Berries";
    }

    public boolean collision(Organism o) {
        if (o instanceof Animal){
            world.deleteOrganism(o.getOrganismX(), o.getOrganismY());
            return true;
        }
        return super.collision(o);
    }

}
