package com.company;

import javax.swing.*;
import java.awt.*;


public class draw2D extends JPanel {

    Player p = new Player();

    draw2D() {
        repaint();
        setPreferredSize(new Dimension(600, 600));

    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);


        g.setColor(Color.red);
        g.fillPolygon(p.xPoints, p.yPoints, 4);
        g.fillPolygon(p.xPoints, p.yPoints, 4);

    }
    /*Polygon polygon = new Polygon(xValue, yValue,int x);


    jp.drawPolygon(p.xPoints, p.yPoints, 4);
    jp.setColor(Color.red);
*/


}
