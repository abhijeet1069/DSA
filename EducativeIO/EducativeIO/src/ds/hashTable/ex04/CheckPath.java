package ds.hashTable.ex04;

import java.util.HashMap;
import java.util.Map;

/*
Implement the tracePath() function to find the starting point of a journey and print out the 
complete path from start to end.

Sample Input:
	map = {
    "NewYork" -> "Chicago"
    "Boston" -> "Texas"
    "Missouri" -> "NewYork"
    "Texas" -> "Missouri"
}

Sample Output:
	"Boston->Texas, Texas->Missouri, Missouri->NewYork, NewYork->Chicago,"

Algorithm:
	Assuming, a map has at-least two vertices.

	Find the starting vertex with no incoming edges.Should be 1. If its more than 1 then means 
	map is disconnected. return "NA"
   	
   	Once starting vertex is found simply traverse the map and append as string.
 	Boston->Texas, Texas->Missouri, Missouri->NewYork, NewYork->Chicago
 	Boston->Texas,Texas->Missouri,Missouri->NewYork,NewYork->Chicago,
 **/
class CheckPath {

  public static String tracePath(Map<String,String> map) {
 String result = "";
	    HashMap<String,String> revMap = new HashMap<>();
	    for(String key : map.keySet()) {
	    	revMap.put(map.get(key), key);
	    }
	  
	    int disconnectedNodeCount = 0;
	    String startVertex = "";
	    for(String key : map.keySet()) {
	    	if(!(revMap.containsKey(key))) { //revMap keys are map values
	    		disconnectedNodeCount++;
	    		startVertex = key;
	    	}
	    }
	    if(disconnectedNodeCount == 1) {
	    	for(String str = startVertex; map.get(str) != null; str = map.get(str)) {
	    		result += str+"->"+map.get(str)+", ";
	    	}
	    }
	    else {
	    	result = "NA";
	    }
	    return result; 
  }
  
  public static void main(String[] args) {
	  HashMap<String,String> map = new HashMap<>();
	  map.put("NewYork","Chicago");
	  map.put("Boston","Texas");
	  map.put("Missouri","NewYork");
	  map.put("Texas","Missouri");
	  
	  System.out.println(tracePath(map));
  }
  
  
  
  
  
  
  
  
  
  
}