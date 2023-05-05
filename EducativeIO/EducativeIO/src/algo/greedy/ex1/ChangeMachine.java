package algo.greedy.ex1;

import java.util.ArrayList;

/*
Print the number and type of coin for a given amount.
Input:
	50
	
Output:
	25,25
 * */


public class ChangeMachine 
{
	  // a public collection of available coins
	  public static int [] coins = {25, 10, 5, 1}; 

	   public static  ArrayList<Integer> getMinCoins(int amount) {
		    ArrayList<Integer> change = new ArrayList<Integer>();
		    int coinIndex = 0;
		    while(amount > 0 && coinIndex < coins.length) { //last change of 1 is a savior
		    	if(amount >= coins[coinIndex]) {
		    		amount = amount - coins[coinIndex];
		    		change.add(coins[coinIndex]);
		    	}
		    	else {
		    		coinIndex++;
		    	}
		    }
		    return change;
		  }
	   
	   public static void main(String[ ]args) {
		   int amount = 50;
		   System.out.println(getMinCoins(amount));
	   }
	}
