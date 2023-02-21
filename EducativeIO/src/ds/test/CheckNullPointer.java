package ds.test;

/**
 * Avoiding null pointer exception using constants from config.
 * */

public class CheckNullPointer {
    public static void main(String[] args) {
        String str = null;
        String str2 = "hello";
        //(str.equalsIgnoreCase(str2)) returns null pointer exception
        if(str2.equalsIgnoreCase(str))
            System.out.println("both are equal");
        else
            System.out.println("both are separate");
    }
}
