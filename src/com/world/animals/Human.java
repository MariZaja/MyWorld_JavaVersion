package com.world.animals;

import com.world.World;

public class Human extends Animal {

    protected int direction;
    protected int tempForce;
    protected int powerDelay;

    public Human(World w, int x, int y) {
        super(w, x, y);
        force = 5;
        tempForce = 5;
        initiative = 4;
        direction = 0;
        ID = 10;
        powerDelay = 0;
        color = 0;
        name = "Human";
    }

    public void action() {
        switch (direction) {
            case 0 -> //UP
                    world.move(organismX, organismY, organismX, organismY - 1);
            case 1 -> //RIGHT
                    world.move(organismX, organismY, organismX + 1, organismY);
            case 2 -> //DOWN
                    world.move(organismX, organismY, organismX, organismY + 1);
            case 3 -> //LEFT
                    world.move(organismX, organismY, organismX - 1, organismY);
        }
    }

    public void setDirection(int d) {
        direction = d;
        System.out.println("Direction set");
        System.out.println(direction);
    }

    public void draw(){
        System.out.print("H");
    }

    public void setPower(int p) {
        //if (p != 0){ world.setCommentary(2, 0, 0); }
        if (powerDelay == 0){ force = tempForce + p; }
        else { powerDelay -= 1; force = tempForce; }
        if (p == 1) { powerDelay = 5; }
    }

    public void forceBoost(int f) {
        tempForce += f;
        super.forceBoost(f);
    }

    public int getPowerDelay() {
        return powerDelay;
    }

    public int getTempForce() {
        return tempForce;
    }

    public void setPowerDelay(int d) {
        powerDelay = d;
    }

    public void setTempForce(int t) {
        tempForce = t;
    }

}
