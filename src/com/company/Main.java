package com.company;

public class Main {

    // http://www.classicgaming.cc/classics/asteroids/graphics

    public static void main(String[] args) {
        View view = new View();
        Model model = new Model();
	    Controller controller = new Controller(model, view);
    }
}
