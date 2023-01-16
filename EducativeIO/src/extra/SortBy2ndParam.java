package extra;

import java.util.Arrays;
import java.util.Comparator;

/*
* Sort array on basis of second Parameter.
* */
public class SortBy2ndParam {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2},{3,4},{2,4},{5,-1},{8,10},{1,2}};
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1],o2[1]);
            }
        });
        for(int[] temp : arr){
            System.out.println(temp[0]+" "+temp[1]);
        }
    }
}
