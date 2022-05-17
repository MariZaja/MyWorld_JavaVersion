package com.world.plants;

import com.world.Organism;
import com.world.World;
import com.world.animals.Animal;

public class Hogweed extends Plant{

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
                    if (world.organisms[target] != null && world.organisms[target] instanceof Animal){
                        //world.setCommentary(0, this->getID(), world.organisms[target]->getID());
                        world.deleteOrganism(organismX+a, organismY+b);
                    }
                }b++;
            }b--;
            a++;
        }
    }

    public boolean collision(Organism o) {
        if (o instanceof Animal){
            world.deleteOrganism(o.getOrganismX(), o.getOrganismY());
            return true;
        }
        return super.collision(o);
    }

}
