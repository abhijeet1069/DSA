package learning;

import java.util.Arrays;
import java.util.Comparator;

public class Sort2DArray {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,4},{3,4},{33,55}};
        Arrays.sort(arr, new Comparator<int[]>() { //can be changed using lambda expression
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1],o2[1]);
            }
        });

        for(int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++)
                System.out.print(arr[i][j]+" ");
            System.out.println();
        }
    }
}
