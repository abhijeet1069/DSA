package mod2.strings;

import java.util.HashSet;
import java.util.Set;

public class StringSegmentation {
    public static boolean canSegmentString(String inputString, Set<String> dictionary) {
        String input = "apple";
        System.out.println(dictionary.contains(input));
        return false;
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("apple");
        set.add("pear");
        set.add("pier");
        set.add("pie");
        String input = "applepie";
        System.out.println(canSegmentString(input,set));
    }
}
