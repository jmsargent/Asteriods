package com.company;
import javax.swing.*;
import java.awt.*;

public class View {
    //This is where we paint stuff

    public JFrame f = new JFrame("Asteroirds");
    public JPanel g = new JPanel();

    private Controller c;
    private Player pp;


    void frameBoard() {
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(600, 600);
        f.setLocation(20, 20);
        g.setBackground(Color.black);
        f.addKeyListener(c);
        f.add(g);
        f.setVisible(true);
        f.repaint();


    }



    void Draw2D (){

    }

}