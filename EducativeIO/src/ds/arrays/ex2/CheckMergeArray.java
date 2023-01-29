package ds.arrays.ex2;
/**
 Merge sorted arrays into a single array.
 Input:
    arr1 = {1, 3, 4, 5}
    arr2 = {2, 6, 7, 8}
 Output:
    arr = {1, 2, 3, 4, 5, 6, 7, 8}
 * **/
public class CheckMergeArray {
    public static int[] mergeArrays(int[] arr1, int[] arr2){
        int size1 = arr1.length;
        int size2 = arr2.length;
        int[] res = new int[size1+size2];
        int i = 0, j = 0, k = 0;
        while(i < size1 && j < size2){
            if(arr1[i] <= arr2[j]){
                res[k] = arr1[i];
                i++;
            }
            else{
                res[k] = arr2[j];
                j++;
            }
            k++;
        }

        while(i < size1){ //consume remaining elements if left
            res[k] = arr1[i];
            i++;
            k++;
        }

        while(j < size2){ //consume remaining elements if left
            res[k] = arr2[j];
            j++;
            k++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1,3,4,5,8,10,11,12};
        int[] arr2 = new int[]{2,6,7,8};

        for(int temp : mergeArrays(arr1,arr2)){
            System.out.print(temp+" ");
        }
    }
}
