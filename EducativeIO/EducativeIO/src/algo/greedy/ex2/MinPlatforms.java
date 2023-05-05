package algo.greedy.ex2;

import java.util.Arrays;

/*
Implement a function that returns the minimum number of platforms that are required for the trains so that 
none of them wait.

Input:
	Arrival Time	Departure Time
		9:00			9:10
		9:40		    12:00
		9:50			11:20
		11:00			11:30
		15:00			19:00
		18:00			20:00
		
 arrival[] = {900, 940, 950, 1100, 1500, 1800};
 departure[] = {910, 1200, 1120, 1130, 1900, 2000};
 
 Output
 	Minimum platforms needed = 3

Beautiful approach : Since, we are refactoring mergesort and not using any additional data-structures.

Algorithm from GeekForGeeks
arr[]  = {9:00,  9:40, 9:50,  11:00, 15:00, 18:00}
dep[]  = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00}

All events are sorted by time.

Total platforms at any time can be obtained by subtracting total departures from total arrivals by that time.

 Time      Event Type     Total Platforms Needed at this Time
 9:00       Arrival                      1
 9:10       Departure                	 0
 9:40       Arrival                      1
 9:50       Arrival                      2
 11:00      Arrival                      3 
 11:20      Departure               	 2
 11:30      Departure               	 1
 12:00      Departure               	 0
 15:00      Arrival                      1
 18:00      Arrival                      2 
 19:00      Departure               	 1
 20:00      Departure               	 0

Minimum Platforms needed on railway station = Maximum platforms needed at any time = 3
 * */

public class MinPlatforms {
 public static int findPlatform(int[] arrival, int[] departure) {
		int size1 = arrival.length;
		int size2 = departure.length;
		int[] res = new int[size1+size2];
		int i = 0, j = 0, k = 0;
		Arrays.sort(arrival);
		Arrays.sort(departure);
		int count = 0, maxCount = 0;
		while(i < size1 && j < size2){
			if(arrival[i] <= departure[j]){
				res[k] = arrival[i];
				i++;
				count++; //arrival
			}
			else{
				res[k] = departure[j];
				j++;
				count--; //departure
			}
			k++;
			maxCount = Math.max(count, maxCount);
		}

		while(i < size1){ //consume remaining elements if left
			res[k] = arrival[i];
			i++;
			k++;
			count++; //arrival
		}

		while(j < size2){ //consume remaining elements if left
			res[k] = departure[j];
			j++;
			k++;
			count--; //departure
		}
		maxCount = Math.max(count, maxCount);
		return maxCount;
	}
}
