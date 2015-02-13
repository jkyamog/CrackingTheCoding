package cracking.the.coding;

import java.util.HashSet;
import java.util.Set;

public class FindCommonString {

    public static void main(String[] args) {
        String[] strs1 = {"foo", "bar", "melon", "cow"};
        String[] strs2 = {"moo", "bar", "car", "now"};

        System.out.println(findCommonBetween2(strs1, strs2));
    }

    public static String findCommonBetween(String[] strs1, String[] strs2) {
        for (String str1 : strs1) {
            for (String str2 : strs2) {
                if (str1.equals(str2)) {
                    return str1;
                }
            }
        }

        return "";
    }

    public static String findCommonBetween2(String[] strs1, String[] strs2) {
        Set<String> strs2Set = new HashSet<String>();

        for (String str2 : strs2) {
            strs2Set.add(str2);
        }

        for (String str1 : strs1) {
            if (strs2Set.contains(str1)) return str1;
        }

        return "";
    }

}
