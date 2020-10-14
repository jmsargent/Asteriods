package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class View extends JFrame {
    //This is where we paint stuff
    private Controller c = new Controller();
    private Player p = new Player((double) this.getWidth() / 2, (double) this.getHeight() / 2, 1);
    JPanel draw = new draw2D();
    Model qq = new Model();

    //init controller to be available for our frame
    public void View(Controller k, draw2D draw, Model qq) {
        this.c = k;
        this.draw = draw;
        this.qq = qq;
    }

    public int getFrameSizeHeight() {
        System.out.println(getHeight());
        return getHeight();
    }

    //Hur ofta som bräder uppdateras (nu 45 FPS)
    Timer t = new Timer(22, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            c.repaint();
        }
    });

    //Här skapas brädet
    void frameBoard() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setLocation(20, 20);
        this.add(c);
        this.add(draw);
        //needed?
        //this.pack();
        this.setVisible(true);
        draw.setBackground(Color.black);

        //c.setVisible(true);
        this.addKeyListener(c);
        //c.addPlayer(qq.p);
        c.addAss();
        t.start();


    }

    public void paintAss() {

    }


}