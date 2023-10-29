package com.codevish.dsalogrithms.arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSumProblem {

    public static int[] solution(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int compliment = target - nums[i];

            if (map.containsKey(compliment)) {
                return new int[] {i, map.get(compliment)};
            } else {
                map.put(nums[i], i);
            }
        }

        throw new IllegalArgumentException("Could not find elements in the array");

    }

    public static void main(String[] args) {


        int[] arr = new int[] {3,3};
        int target = 6;

        int[] result = solution(arr, target);

        System.out.printf("%d,%d%n", result[0], result[1]);

    }
}
