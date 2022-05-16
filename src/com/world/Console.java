package com.world;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Console implements KeyListener {

    int instruction;
    int power;
    static final int POWER = -1;
    static final int UP = 0;
    static final int RIGHT = 1;
    static final int DOWN = 2;
    static final int LEFT = 3;

    public Console()
    {

    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_UP){ instruction = UP; System.out.println("UP"); }
        else if(e.getKeyCode()==KeyEvent.VK_DOWN){ instruction = DOWN; System.out.println("DOWN"); }
        else if(e.getKeyCode()==KeyEvent.VK_RIGHT){ instruction = RIGHT; System.out.println("RIGHT"); }
        else if(e.getKeyCode()==KeyEvent.VK_LEFT){ instruction = LEFT; System.out.println("LEFT"); }
        else if(e.getKeyCode()==KeyEvent.VK_P){ power = 5; instruction = POWER; }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
