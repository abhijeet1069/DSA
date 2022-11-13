package educativeIO.mod2.arrays;

import java.util.*;

class Subsets {
    /**Start with an empty set.
     * Fetch all the contents and keep adding the current Element to all subsets of superset.
     */

    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> superset = new ArrayList<>();
        superset.add(new ArrayList<>());
        for(int num : nums){
            int size = superset.size();
            for(int i = 0; i < size; i++){
                //new ArrayList<> is important. Else changes keep happening to current subset in superset
                List<Integer> subset = new ArrayList<>(superset.get(i));
                subset.add(num);
                superset.add(subset);
            }
        }
        return superset;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = Subsets.findSubsets(new int[] { 1, 2, 3 });
        System.out.println("Here is the list of subsets: " + result);
    }
}