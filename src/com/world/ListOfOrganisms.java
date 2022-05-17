package com.world;

import com.world.animals.*;
import com.world.plants.*;
import java.util.ArrayList;

public class ListOfOrganisms {

    ArrayList<Organism> orgList;

    public ListOfOrganisms(World w){
        orgList = new ArrayList<Organism>();
        orgList.add(new Grass(w, 0, 0));
        orgList.add(new Dandelion(w, 0, 0));
        orgList.add(new Guarana(w, 0, 0));
        orgList.add(new WolfBerries(w, 0, 0));
        orgList.add(new Hogweed(w, 0, 0));
        orgList.add(new Wolf(w, 0, 0));
        orgList.add(new Sheep(w, 0, 0));
        orgList.add(new Fox(w, 0, 0));
        orgList.add(new Turtle(w, 0, 0));
        orgList.add(new Antelope(w, 0, 0));
        orgList.add(new Human(w, 0, 0));
    }
}