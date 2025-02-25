package Longest_Substring_WithOut_Repeating_Characters;

import java.util.HashSet;

public class Solution {
    public static int lengthOfSubstring(String s){
        int maxLength = 0;
        int left = 0;
        int right = 0;
        int n = s.length();

        HashSet<Character> set = new HashSet<>();

        while(right < n){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;
                maxLength = Math.max(maxLength, right - left);
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        return maxLength;
    }
    public static void main(String[] args) {
        String s = "abcabcbb";

        System.out.println("Longest subsequence of non repeating characters : " + lengthOfSubstring(s));

    }
}
