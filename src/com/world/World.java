package com.world;

import com.world.animals.Human;
import com.world.plants.Grass;

import java.util.ArrayList;

public class World {
    private static final int MAX_INITIATIVE = 8;
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
        organisms[0] = h;
        organismsIniciative.get(h.getInitiative()).add(h);
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

    public int getAge(){
        return worldAge;
    }

}
