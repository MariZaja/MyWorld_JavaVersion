package com.world;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Board extends JFrame implements ActionListener, KeyListener
{
    public static final int SIZE = 20;
    protected JLabel instText, widthL, heightL;
    protected JTextField inst, widthT, heightT;
    protected JButton button;
    protected JButton[] board;
    protected World world;
    protected int x, y;
    int instruction;
    int power;
    static final int POWER = -1;
    static final int UP = 0;
    static final int RIGHT = 1;
    static final int DOWN = 2;
    static final int LEFT = 3;

    public Board(World w)
    {
        world = w;
        System.out.println("Board created");
        setSize(1000,600);
        setTitle("MyWorld");
        setLayout(null);

        widthL = new JLabel("X: ");
        widthL.setBounds(20, 20, 50, 20);
        add(widthL);

        heightL = new JLabel("Y: ");
        heightL.setBounds(20, 70, 50, 20);
        add(heightL);

        widthT = new JTextField("");
        widthT.setBounds(70, 20, 50, 20);
        add(widthT);

        heightT = new JTextField("");
        heightT.setBounds(70, 70, 50, 20);
        add(heightT);

        button = new JButton("OK");
        button.setBounds(20, 100, 150, 20);
        add(button);
        button.addActionListener(this);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        //Board app = new Board();
        //app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //app.setVisible(true);
    }

    public void setSquareBoard()
    {
        getContentPane().removeAll();
        getContentPane().repaint();

        instText = new JLabel("Instruction: ");
        instText.setBounds(x*SIZE + 20, 20, 80, 20);
        add(instText);

        inst = new JTextField();
        inst.setBounds(x*SIZE + 100, 20, 30, 20);
        add(inst);
        inst.addKeyListener(this);

        for(int i=0; i < x; i++) {
            for(int j=0; j < y; j++) {
                add(board[j*x+i]);
                board[j*x+i].addActionListener(this);
            }
        }
    }

    public void setButtons()
    {
        board = new JButton[x*y];
        for(int i=0; i < x; i++) {
            for(int j=0; j < y; j++) {
                board[j*x+i] = new JButton();
                board[j*x+i].setBounds(10 + i*SIZE, 10 + j*SIZE, SIZE, SIZE);
                board[j*x+i].setBackground(Color.WHITE);
            }
        }
    }

    public void setColors()
    {
        for(int i=0; i < x; i++) {
            for(int j=0; j < y; j++) {
                if (world.organisms[j * x + i] != null){ board[j*x+i].setBackground(new Color(world.organisms[j*x+i].getColor())); }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == button)
        {
            x = Integer.parseInt(widthT.getText());
            y = Integer.parseInt(heightT.getText());
            setButtons();
            world.setWorld(x, y);
            world.start();
            remove(button);
        }
        else
        {
            for(int i=0; i < x; i++)
            {
                for(int j=0; j < y; j++)
                {
                    if (source == board[j*x+i])
                    {
                        System.out.println(j*x+i);
                    }
                }
            }
        }
    }

    public int getInstruction() {
        return instruction;
    }

    public int getPower() {
        if (power != 0){ power -= 1; return power+1; }
        else{ return 0; }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_UP){ instruction = UP; world.start(); }
        else if(e.getKeyCode()==KeyEvent.VK_DOWN){ instruction = DOWN; world.start(); }
        else if(e.getKeyCode()==KeyEvent.VK_RIGHT){ instruction = RIGHT; world.start(); }
        else if(e.getKeyCode()==KeyEvent.VK_LEFT){ instruction = LEFT; world.start(); }
        else if(e.getKeyCode()==KeyEvent.VK_P){ power = 5; instruction = POWER; }
        else if(e.getKeyCode()==KeyEvent.VK_ESCAPE){ setVisible(false); dispose(); }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

}