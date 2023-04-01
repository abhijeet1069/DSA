package ds.hashTable.ex03;

import java.util.HashMap;

//Hash Set  =>  HashSet<Integer> hSet = new HashSet<>();
//HashMap   =>  HashMap<Integer,String> hMap = new HashMap<>();
//HashTable =>  Hashtable<Integer,String> hTable = new Hashtable<>();
//Hash Set Functions => {add(), remove(), contains()}
//Hash Map and Table Functions => {put(key,value), get(key), remove(key), containsKey(key), containsValue(value)}
class CheckSymmetric {
    public static String findSymmetric(int[][] arr) {
        String result = "";
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            int first = arr[i][0];
            int second = arr[i][1];
            int val = map.getOrDefault(second,Integer.MIN_VALUE);
            if(val != Integer.MIN_VALUE && val == first){
                result += String.format("{%d,%d}",second,first)+",";
            }
            else{
                map.put(first,second);
            }
        }
        if(result.length() > 0){
            return result.substring(0,result.length()-1);
        }
        else
            return "";
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2}, {3, 4}, {5, 9}, {4, 3}, {9, 5}};
        System.out.println(findSymmetric(arr));
    }
}
