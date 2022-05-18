package com.world;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Board extends JFrame implements ActionListener, KeyListener
{
    public static final int SIZE = 20;
    protected JLabel widthL, heightL;
    protected JTextField widthT, heightT;
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
        widthT.setBounds(70, 70, 50, 20);
        add(widthT);

        heightT = new JTextField("");
        heightT.setBounds(70, 20, 50, 20);
        add(heightT);

        button = new JButton("OK");
        button.setBounds(20, 100, 150, 20);
        add(button);
        button.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(true);
    }

    public void setSquareBoard()
    {
        getContentPane().removeAll();
        getContentPane().repaint();

        for(int i=0; i < x; i++) {
            for(int j=0; j < y; j++) {
                add(board[j*x+i]);
                board[j*x+i].addActionListener(this);
            }
        }

        printColors();
    }

    public void setButtons()
    {
        board = new JButton[x*y];
        for(int i=0; i < x; i++) {
            for(int j=0; j < y; j++) {
                board[j*x+i] = new JButton();
                board[j*x+i].setBounds(10 + j*SIZE, 10 + i*SIZE, SIZE, SIZE);
                board[j*x+i].setBackground(Color.WHITE);
            }
        }
    }

    public void setColors()
    {
        for(int i=0; i < x*y; i++) {
            if (world.organisms[i] != null){ board[i].setBackground(new Color(world.organisms[i].getColor())); }
            else if (world.organisms[i] == null){ board[i].setBackground(Color.WHITE); }
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

    private void printColors(){
        ListOfOrganisms l = new ListOfOrganisms(world);
        for (int i = 0; i < 11; i++)
        {
            JPanel rectangle = new JPanel();
            rectangle.setBackground( new Color(l.orgList.get(i).getColor()));
            rectangle.setBounds(y*SIZE + 80, i*30 + 10, 20, 20);
            add( rectangle );

            JLabel description = new JLabel(l.orgList.get(i).getName());
            description.setBounds(y*SIZE + 110, i*30 + 10, 80, 20);
            add(description);
        }
    }

}