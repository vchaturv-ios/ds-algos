package Strings;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

    public static int lengthOfLongestSubstring(String input) {
        int start = 0;
        int end = 0;

        Set<Character> seen = new HashSet<>();

        int max = 0;

        while (start < input.length()) {
            if (!seen.contains(input.charAt(start))) {
                if(start-end+1 > max) {
                    max = start-end+1;
                }
                seen.add(input.charAt(start));
                start++;
            } else {
                seen.remove(input.charAt(end));
                end++;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        String input = "pwkefgherer";
        System.out.println(lengthOfLongestSubstring(input));
    }
}
