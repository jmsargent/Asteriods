package com.company;

public class Asteroids {

    // http://www.classicgaming.cc/classics/asteroids/graphics

    public static void main(String[] args) {
	// write your code here
        Model model = new Model();
        View view = new View(model);

        Controller controller = new Controller(view, model);

    }
}
