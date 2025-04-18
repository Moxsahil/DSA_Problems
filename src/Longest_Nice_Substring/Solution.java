package Longest_Nice_Substring;

public class Solution {
    public String longestNiceSubstring(String s) {
        if (s.length() < 2) return "";

        // Use a set to record all characters in the string
        java.util.Set<Character> set = new java.util.HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // If both lower and upper case exist, continue
            if (set.contains(Character.toLowerCase(c)) && set.contains(Character.toUpperCase(c))) {
                continue;
            }

            // If not, split and check both halves
            String left = longestNiceSubstring(s.substring(0, i));
            String right = longestNiceSubstring(s.substring(i + 1));

            // Return the longer substring (earlier one if equal)
            return left.length() >= right.length() ? left : right;
        }
        
        return s;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.longestNiceSubstring("YazaAay"));
        System.out.println(sol.longestNiceSubstring("Bb"));
        System.out.println(sol.longestNiceSubstring("c"));
    }
}
