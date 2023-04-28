package c1elements.s5inputOutput.exercises;

/*
Setting scale as side of a square and coloring logic is great
 * */

import java.awt.Color;

import c1elements.s5inputOutput.lib.StdDraw;

public class CheckerBoard {

	public static void checkerBoard(int n) {
		StdDraw.enableDoubleBuffering();
		StdDraw.setXscale(0, n); //each unit is a square side long
		StdDraw.setYscale(0, n); //scale was the main idea
		
		for(int i = 0;i < n; i++) {
			for(int j = 0;j < n; j++) {
				if((i+j)%2 == 0) { //main logic
					StdDraw.setPenColor(Color.BLACK);
				}
				else {
					StdDraw.setPenColor(Color.RED);
				}
				StdDraw.filledSquare(i+0.5, j+0.5, 0.5); //(x coordinate of centre of square, y coordinate of centre of square, length of half side)
			}
		}
		StdDraw.show();
	}
	
	public static void main(String[] args) throws InterruptedException {
		checkerBoard(10);

	}

}
