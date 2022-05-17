package com.world;

import java.util.Random;

public abstract class Organism {
    protected int ID;
    protected int initiative;
    protected int force;
    protected int born;
    protected int organismX, organismY, toX, toY;
    protected int color;
    protected String name;
    protected World world;
    protected Random rand;

    public Organism(World w, int x, int y) {
        organismX = x;
        organismY = y;
        world = w;
        born = world.getAge();
        rand = new Random();
        color = 16777215;
    }

    /*bool Organism::collision(Organism *o) {
        if (o->getForce() > this->getForce()){
            world.setCommentary(0, o->getID(), this->getID());
            world.deleteOrganism(organismX, organismY);
        }
    else if(o->getForce() < this->getForce()){
            world.setCommentary(0, this->getID(), o->getID());
            world.deleteOrganism(o->getOrganismX(), o->getOrganismY());
            return true;
        }
    else if (o->getForce() == this->getForce()){
            if(o->getID() == ID){
                world.setCommentary(1, o->getID(), this->getID());
                o->multiply(organismX, organismY);
                return true;
            }
            else{
                world.setCommentary(0, o->getID(), this->getID());
                world.deleteOrganism(organismX, organismY);
            }
        }
    }*/

    public void action() {}

    public int getColor() {
        return color;
    }

    public int getInitiative() {
        return initiative;
    }

    public int getForce() {
        return force;
    }

    public int getAge() {
        return born;
    }

    public void setPosition(int x, int y) {
        organismX = x;
        organismY = y;
    }

    public void setDestination(int fields) {
        toX = organismX + (rand.nextInt(3) - 1) * fields;
        toY = organismY + (rand.nextInt(3) - 1) * fields;
    }

    public int getID() {
        return ID;
    }

    public String getName(){
        return name;
    }

    public int getOrganismY() {
        return organismY;
    }

    public int getOrganismX() {
        return organismX;
    }

    public void forceBoost(int f) {
        force += f;
    }

    /*void Organism::multiply(int x, int y) {
        bool stop=false;
        while(!stop){
            setDestination(1);
            if (toX != x && toY != y && world.checkPosition(toX, toY)){ stop = true; }
        }
        if (world.organisms[toX*world.getWorldY()+toY] == NULL){ world.setNewOrganism(toX, toY, ID); }
    }*/

    public void setForce(int f) {
        force = f;
    }

    public void setAge(int a) {
        born = a;
    }

    public void setInitiative(int i) {
        initiative = i;
    }

}