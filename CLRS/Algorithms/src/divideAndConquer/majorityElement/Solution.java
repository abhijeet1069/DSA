package divideAndConquer.majorityElement;

import java.util.HashMap;

public class Solution {
	
	public static int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int x : nums) {
        	map.put(x,map.getOrDefault(x, 0)+1);
        }
        
        int threshold = nums.length/2;
        for(int key : map.keySet()) {
        	if(map.get(key) > threshold)
        		return key;
        }
        return -1;
    }

	public static void main(String[] args) {
		int[] arr = {2,2,1,1,1,2,2};
		System.out.println(majorityElement(arr));
	}
}
