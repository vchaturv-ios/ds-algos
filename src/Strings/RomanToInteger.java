package Strings;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static Map<Character, Integer> romanToIntegerMap() {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        return map;
    }

    public static void main(String[] args) {
        String input = "XI";
        System.out.println(romanToInteger(input));
    }

    public static int romanToInteger(String input) {
        int ans = 0;
        for (int i = 0; i < input.length(); i++) {
            if ((i < (input.length() - 1)) && (romanToIntegerMap().get(input.charAt(i)) < romanToIntegerMap().get(input.charAt(i + 1)))) {
                ans-=romanToIntegerMap().get(input.charAt(i));
            } else {
                ans+=romanToIntegerMap().get(input.charAt(i));
            }
        }
        return ans;
    }
}
