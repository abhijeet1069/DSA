package algo.dc.ex1;

/*
Given two integers a and b, calculate the largest number (GCD) that divides both of them without leaving a remainder.

Input
	x = 15 , y = 75

Output
	GCD = 15
 * */

class EuclideanAlgorithm
{ 
    public static int GCD(int a, int b){
        if(a == 0) {
        	return b;
        }
        return GCD(b%a,a);
    }
} 
