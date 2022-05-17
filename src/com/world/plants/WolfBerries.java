package com.world.plants;

import com.world.Organism;
import com.world.World;

public class WolfBerries extends Plant{

    public WolfBerries(World w, int x, int y) {
        super(w, x, y);
        force = 99;
        ID = 3;
    }

    public boolean collision(Organism o) {
        /*if (o->getID()>IF_ANIMAL){
            world.deleteOrganism(o->getOrganismX(), o->getOrganismY());
            return true;
        }
        return Organism::collision(o);*/
        return true;
    }

}
