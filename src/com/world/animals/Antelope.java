package com.world.animals;

import com.world.Organism;
import com.world.World;

public class Antelope extends Animal {

    public Antelope(World w, int x, int y) {
        super(w, x, y);
        force = 4;
        initiative = 4;
        ID = 9;
        color = 16711680;
        name = "Antelope";
    }

    public void action() {
        setDestination(2);
        if (world.checkPosition(toX, toY)){
            world.move(this.organismX, this.organismY, toX, toY);
        }
    }

    public boolean collision(Organism o) {
        int run = rand.nextInt(2);
        int a = -1, b = -1;
        if (run != 0){
            while(a<2){
                while(b<2){
                    int target = (organismX+a)*world.getWorldY()+(organismY+b);
                    if (world.checkPosition(organismX+a, organismY+b)){
                        if (world.organisms[target] == null){
                            world.move(organismX, organismY,organismX+a, organismY+b);
                        }
                    }b++;
                }b--;
                a++;
            }
            return true;
        }
        return super.collision(o);
    }
}
