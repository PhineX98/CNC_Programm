package application;

import javafx.scene.shape.Circle;

public class Animation {
	
	protected static Circle temp;

	protected static double getDauer(double geschwind, double a, double b) {
		double c = a*a + b*b;
		c = Math.sqrt(c);
		
		return c/geschwind;
	}
}
