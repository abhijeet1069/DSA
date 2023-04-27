package c1elements.s5inputOutput.exercises;

/*
Find the closest point to P(x,y,z)
 * */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Point{
	double x;
	double y;
	double z;
	Point(Double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public String toString() {
		return "x = "+this.x+" , y = "+this.y+" , z = "+this.z;
	}
}

public class Closest {
	
	public static double distance(Point p1, Point p2) {
		double x2 = (p1.x-p2.x)*(p1.x-p2.x);
		double y2 = (p1.y-p2.y)*(p1.y-p2.y);
		double z2 = (p1.z-p2.z)*(p1.z-p2.z);
		return x2+y2+z2;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		Point p = new Point(1.0,2.0,3.0);
		BufferedReader br = new BufferedReader(new FileReader("/Users/satyam/Personal/DSA/PrincetonCS/ComputerScience/res/points.txt"));
		int tc = Integer.parseInt(br.readLine());
		for(int i = 0; i < tc; i++) {
			String strInput = br.readLine();
			String[] strInputArr = strInput.split(" ");
			double x = Double.parseDouble(strInputArr[0]);
			double y = Double.parseDouble(strInputArr[1]);
			double z = Double.parseDouble(strInputArr[2]);
			Point p1 = new Point(x,y,z);
			System.out.println(p.toString()+"\n"+p1.toString()+"\nDistance: "+distance(p,p1));
		}
	}

}
