package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class View extends JFrame {
    //This is where we paint stuff
    private Controller c = new Controller();
    private Player p = new Player((double) this.getWidth() / 2, (double) this.getHeight() / 2, 1);
    JPanel jp = new JPanel();
    JComponent draw = new draw2D();


    //init controller to be available for our frame
    public void View(Controller k, draw2D draw) {
        this.c = k;
        this.draw = draw;
    }

    //Hur ofta som bräder uppdateras (nu 45 FPS)
    Timer t = new Timer(22, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            jp.repaint();
        }
    });

    //Här skapas brädet
    void frameBoard() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setLocation(20, 20);
        this.add(jp);
        jp.setBackground(Color.black);
        jp.setSize(500, 500);
        jp.setVisible(true);


        jp.repaint();
        jp.addKeyListener(c);
        this.addPlayer(p);

        t.start();
    }

    public void addPlayer(Player p) {
        this.p = p;
        p.posX = (double) this.getWidth() / 2;
        p.posY = (double) this.getHeight() / 2;
        p.life = 1;
        p.color = Color.cyan;
        System.out.println("I'm here!");

    }

    public class draw2D extends JComponent {
        private static final long serialVersionUID = 1L;

        draw2D() {
            setPreferredSize(new Dimension(600, 600));
        }

    }


    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        g.fillRect(200, 62, 30, 10);
        g.setColor(Color.red);
    }
    /*Polygon polygon = new Polygon(xValue, yValue,int x);


    jp.drawPolygon(p.xPoints, p.yPoints, 4);
    jp.setColor(Color.red);
*/

    private void DrawAsteroid(Asteroid ass, Graphics g) {


    }

}