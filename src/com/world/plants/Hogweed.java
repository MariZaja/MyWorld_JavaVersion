package com.world.plants;

import com.world.Organism;
import com.world.World;

public class Hogweed extends Plant{

    private static final int IF_ANIMAL = 4;

    public Hogweed(World w, int x, int y) {
        super(w, x, y);
        force = 10;
        ID = 4;
        color = 10066176;
        name = "Hogweed";
    }

    public void action() {
        super.action();
        int a = -1, b = -1;
        int target = (organismX+a)*world.getWorldY()+(organismY+b);
        while(a<2){
            while(b<2){
                target = (organismX+a)*world.getWorldY()+(organismY+b);
                if (world.checkPosition(organismX+a, organismY+b)){
                    if (world.organisms[target] != null && world.organisms[target].getID()>IF_ANIMAL){
                        //world.setCommentary(0, this->getID(), world.organisms[target]->getID());
                        world.deleteOrganism(organismX+a, organismY+b);
                    }
                }b++;
            }b--;
            a++;
        }
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
