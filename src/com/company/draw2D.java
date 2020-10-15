package com.company;

import javax.swing.*;
import java.awt.*;


public class draw2D extends JPanel {

    draw2D() {
        repaint();
        setPreferredSize(new Dimension(600, 600));
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);


        g.setColor(Color.red);

        // g.fillPolygon();


    }
    //Polygon polygon = new Polygon(xValue, yValue,int x);


}
/*
    jp.drawPolygon(p.xPoints, p.yPoints, 4);
    jp.setColor(Color.red);
*/



