package maximum_length_substring_with_two_occurrences;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int maximumLengthSubstring(String s) {
        int maxLength = 0;
        Map<Character, Integer> frequency = new HashMap<>();

        int left = 0;
        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);

            while(frequency.get(ch) > 2){
                char leftChar = s.charAt(left);
                frequency.put(leftChar, frequency.get(leftChar) - 1);
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
    public static void main(String[] args) {
        String s = "bcbbbcba";

        Solution sol = new Solution();

        int result = sol.maximumLengthSubstring(s);

        System.out.print("The maximum length of substring is : " + result);
    }
}
