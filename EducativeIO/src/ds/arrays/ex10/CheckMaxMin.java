package ds.arrays.ex10;
/**
 Given a sorted array, rearrange the array in max-min form.
 Input - {1,2,3,4,5}
 Output- {5,1,4,2,3}
 * */
public class CheckMaxMin {
    public static void maxMin(int[] arr){
        int left = 0, right = arr.length-1;
        int[] res = new int[arr.length];
        int index = 0;
        while(left <= right) {
            if (index < arr.length) {
                res[index] = arr[right];
                right--;
                index++;
            }
            if (index < arr.length) {
                res[index] = arr[left];
                left++;
                index++;
            }
        }
        for(int i = 0;i < arr.length; i++){
            arr[i] = res[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        maxMin(arr);
        for(int x : arr){
            System.out.print(x+" ");
        }
    }
}
