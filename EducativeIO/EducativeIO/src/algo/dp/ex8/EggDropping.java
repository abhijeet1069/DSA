package algo.dp.ex8;

/*
Given a tall skyscraper and a few eggs, write a function to figure out how many tries it would take to figure out 
which floor of the skyscraper the eggs can be dropped from without breaking. Here are some rules:
	An egg that survives a fall can be used again but a broken egg must be discarded.
	The effect of a fall is the same for all eggs.
	If an egg breaks when dropped from a certain floor, it would also break if dropped from a higher floor.
	If an egg survives a fall from a certain floor, it would also survive a shorter fall.
	
Input:
	int eggs = 6;
	int floors = 15;

Output:
	4

Algo  :The problem is max comparisons to be performed for a binary search. Or Binary search worst case scenario
 * */

public //

class EggDropping
{
    public static int eggDrop(int eggs, int floors){
       int left = 0, right = floors-1;
       int count = 0;
       int mid = 1; //for 1st iteration to be true
       
       if(eggs == 0 || floors == 0) {
    	   return 0;
       }
       
       while(mid != 0) {
    	   mid = (left+right)/2;
    	   right = mid;
    	   count++;
       }
       return count;
    }
};
