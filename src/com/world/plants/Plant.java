package com.world.plants;

import com.world.Organism;
import com.world.World;

import static java.lang.Math.abs;

public abstract class Plant extends Organism {

    public static final int RANDOM = 7;
    protected int probabilityOfSpreading;

    public Plant(World w, int x, int y) {
        super(w, x, y);
        initiative = 0;
        setProbabilityOfSpreading();
    }

    void setProbabilityOfSpreading() {
        probabilityOfSpreading = 0;
        while(probabilityOfSpreading == 0){
            probabilityOfSpreading = abs(rand.nextInt(RANDOM));
        }
    }

    public void action() {
        setDestination(1);
        int spreading = rand.nextInt(probabilityOfSpreading);
        //if (world.checkPosition(toX, toY) && world.organisms[(toX*world.getWorldY())+toY] == NULL && (spreading == 0)){
        //    world.setNewOrganism(toX, toY, this->getID());
        //}
        setProbabilityOfSpreading();
    }
}
