package com.codevish.dsalogrithms.numbers;

public class ReverseInteger {

    public static int reverse(int num) {
        int rem = 0, reverse = 0;

        while (num != 0) {
            rem = num%10;
            reverse = (reverse*10)+rem;
            num = num/10;
        }

        return reverse;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-123));
    }
}
