package mod2.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortedArraySquares {

    //Merge two arraylist into a single array
    public static int[] merge(ArrayList<Integer> left, ArrayList<Integer> right){
        int sizeLeft = left.size();
        int sizeRight = right.size();
        int[] res = new int[sizeLeft+sizeRight];
        int i = 0, j = 0, index=0;
        while((i < sizeLeft) && (j < sizeRight)){
            if(left.get(i) <= right.get(j)){
                res[index] = left.get(i);
                i++;
            }
            else{
                res[index] = right.get(j);
                j++;
            }
            index++;
        }
        while(i < sizeLeft){
            res[index] = left.get(i);
            i++;
            index++;
        }
        while(j < sizeRight){
            res[index] = right.get(j);
            j++;
            index++;
        }
        return res;
    }
    public static int[] makeSquares(int[] arr) {
        ArrayList<Integer> negative = new ArrayList<>();
        ArrayList<Integer> positive = new ArrayList<>();
        for(int i = 0 ; i < arr.length; i++) {
            /*Add arraylist to the beginning of list*/
            if (arr[i] < 0)
                negative.add(0, arr[i] * arr[i]);
            else
                positive.add(arr[i] * arr[i]);
        }
        int[] squares = merge(positive, negative);
        return squares;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-2, -1, 0, 2, 3};
        //ArrayList<Integer> left = new ArrayList<>(List.of(-5,-4,-2,1));
        //ArrayList<Integer> right= new ArrayList<>(List.of(-5,-4,-2,1,9));
        int[] res = makeSquares(arr);
        for(int x : res)
            System.out.println(x);
    }
}
