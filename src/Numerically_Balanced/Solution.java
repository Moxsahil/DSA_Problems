package Numerically_Balanced;

import java.util.*;

public class Solution {
    public static int nextBeautifulNumber(int n) {
        while (true) {
            n++;
            if (isNumericallyBalanced(n)) {
                return n;
            }
        }
    }

    private static boolean isNumericallyBalanced(int num) {
        String s = String.valueOf(num);
        Map<Character, Integer> freqMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            if (entry.getKey() - '0' != entry.getValue()) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(nextBeautifulNumber(1));
        System.out.println(nextBeautifulNumber(1000));
        System.out.println(nextBeautifulNumber(3000));
    }
}
