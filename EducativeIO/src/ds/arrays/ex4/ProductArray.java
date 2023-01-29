package ds.arrays.ex4;

public class ProductArray {
    public static int[] findProduct1(int arr[]){ //MyVersion
        int[] result = new int[arr.length];
        int product = 1;
        for(int temp : arr)
            product *= temp;
        for(int i = 0 ; i < arr.length; i++){
            if(arr[i] != 0){
                result[i] = product/arr[i];
            }
            else{ //resolved to brute force to avoid divide by zero situation
                int lhp = 1;
                int rhp = 1;
                for(int j = 0; j < i; j++)
                    lhp *= arr[j];
                for(int j = i+1; j < arr.length; j++)
                    rhp *= arr[j];
                result[i] = lhp*rhp;
            }
        }
        return result;
    }

    public static int[] findProduct2(int arr[]) { //Better Version
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,2,1,5,0};
        for(int temp : findProduct1(arr))
            System.out.print(temp+" ");
    }
}
