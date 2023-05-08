package algo.dp.ex1;

/*
Given two integer arrays that represent the weights and profits of N items, implement a function 
knapSack() that finds a subset of these items that will gives us the maximum profit without their 
cumulative weight exceeding a given number capacity. Each item can only be selected once, which means 
we either skip it or put it in the knapsack.

Input:
	profit[] = {60, 100, 120}; 
    weight[] = {10, 20, 30}; 
    capacity = 50;
    
Output:
	220
 * */

public class KnapsackProblem{ 
    static int Knapsack(int profits[], int profitsLength, int weights[], int weightsLength, int capacity){
         int[][] profitMatrix = new int[weights.length+1][capacity+1]; 
       for(int i = 1; i < profitMatrix.length; i++) { //i is weight
    	   for(int j = 1; j < profitMatrix[0].length; j++) { //j represents current capacity
    		  int leave = profitMatrix[i-1][j];
    		  int take;
    		  int remCapacity = j - weights[i-1];
    		  if(remCapacity >= 0) {
    			  take = profits[i-1]+profitMatrix[i-1][remCapacity]; //memoization of remaining capacity.
    		  }
    		  else {
    			  take = leave;
    		  }
    		  profitMatrix[i][j] = Math.max(leave, take);
    	   }
       }
       return profitMatrix[profitMatrix.length-1][profitMatrix[0].length-1];
    }
    
    public static void main(String[] args) {
    	  int profit[] = {60, 100, 120}; 
    	  int profitsLength = profit.length;
    	  int weight[] = {10, 20, 30}; 
    	  int weightsLength = weight.length;
    	  int capacity = 50; 
    	  
    	  System.out.println(Knapsack(profit,profitsLength,weight,weightsLength,capacity));
    }
}
