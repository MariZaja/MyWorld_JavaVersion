package com.world;

import com.world.animals.*;
import com.world.plants.*;

import java.util.ArrayList;
import java.util.Random;

public class World {
    private static final int MAX_INITIATIVE = 8;
    private static final int START_NUMBER_OF_ORGANISMS = 100;
    private static final int DIFFRENT_ORGANISMS = 10;
    private static final int GRASS = 0;
    protected Random rand;
    int worldX, worldY;
    int worldAge;
    boolean end;
    Board board;
    Human h;
    Organism[] organisms;
    ArrayList<ArrayList<Organism>> organismsIniciative;
    Console console;

    public World()
    {
        System.out.println("World created");
        end = false;
        rand = new Random();
        board = new Board(this);
        console = new Console();
        organismsIniciative = new ArrayList<ArrayList<Organism>>(MAX_INITIATIVE);
        for (int i = 0; i < MAX_INITIATIVE; i++){
            ArrayList<Organism> temp = new ArrayList<Organism>();
            organismsIniciative.add(temp);
        }
        worldAge = 1;
    }

    public void setWorld(int x, int y)
    {
        worldX = x;
        worldY = y;
        organisms = new Organism[worldX*worldY];
        h = new Human(this, 0, 0);
        organismsIniciative.get(h.getInitiative()).add(h);
        setArea();
    }

    public void start()
    {
        if (action()) {
            //commentary();
            worldAge++;
        }
    }

    boolean action()
    {
        if (end){return false;}
        if (worldAge == 1){
            board.setColors();
            board.setSquareBoard();
            //com->author();
            return true;
        }
        h.setDirection(board.getInstruction());
        //h.setPower(board.getPower());

        //com->author();

        for (int i=MAX_INITIATIVE-1; i>=0; i--){
            int size = organismsIniciative.get(i).size();
            for (int j=0; j<size; j++){
                organismsIniciative.get(i).get(j).action();
            }
        }

        board.setColors();
        return true;
    }

    void setArea() {
        organisms[0] = h;
        int x, y;
        for (int i = 0; i < START_NUMBER_OF_ORGANISMS; i++){
            x = rand.nextInt(worldX);
            y = rand.nextInt(worldY);
            if (organisms[x*worldY+y] == null){
                setNewOrganism(x, y, i%DIFFRENT_ORGANISMS);
            }
        }
    }

    public void setNewOrganism(int x, int y, int number) {
        Organism o = null;
        switch (number) {
            case 0 -> { //GRASS
                o = new Grass( this, x, y);
            } case 1 -> { //DANDELION
                o = new Dandelion(this, x, y);
            } case 2 -> { //GUARANA
                o = new Guarana(this, x, y);
            } case 3 -> { //WOLFBERRIES
                o = new WolfBerries(this, x, y);
            } case 4 -> { //HOGWEED
                o = new Hogweed(this, x, y);
            } case 5 -> { //WOLF
                o = new Wolf(this, x, y);
            } case 6 -> { //SHEEP
                o = new Sheep(this, x, y);
            } case 7 -> { //FOX
                o = new Fox(this, x, y);
            } case 8 -> { //TURTLE
                o = new Turtle(this, x, y);
            } case 9 -> { //ANTELOPE
                o = new Antelope(this, x, y);
            }
        }
        organisms[x*worldY+y] = o;
        if (o != null){ organismsIniciative.get(o.getInitiative()).add(o); }
    }

    public int getAge(){
        return worldAge;
    }

}
