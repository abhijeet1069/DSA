package ds.hashTable.ex01;

import java.util.HashMap;

//Hash Set  =>  HashSet<Integer> hSet = new HashSet<>();
//HashMap   =>  HashMap<Integer,String> hMap = new HashMap<>();
//HashTable =>  Hashtable<Integer,String> hTable = new Hashtable<>();
//Hash Set Functions => {add(), remove(), contains()}
//Hash Map and Table Functions => {put(key,value), get(key), remove(key), containsKey(key), containsValue(value)}
class CheckSubset {
    public static boolean isSubset(int[] arr1, int[] arr2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < arr1.length; i++){
            map.put(arr1[i],i);
        }
        for(int i = 0; i < arr2.length; i++){
            if(map.get(arr2[i]) == null){ //if anyone element not found
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isSubset(new int[]{9,4,7,1,-2,6,5},new int[]{7,1,-2}));
    }
}
