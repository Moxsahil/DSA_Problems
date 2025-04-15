package Merge_String_Alternatively;

public class Solution {
    public String mergeAlternatively(String word1, String word2){
        StringBuilder merged = new StringBuilder();
        int length1 = word1.length();
        int length2 = word2.length();

        int i=0;
        int j=0;

        while(i < length1 || j < length2){
            if(i < length1){
                merged.append(word1.charAt(i++));
            }
            if(j < length2){
                merged.append(word2.charAt(j++));
            }
        }
        return merged.toString();
    }
    public static void main(String[] args) {
        String word1 = "abc";
        String word2 = "pqrs";

        Solution sol = new Solution();

        String result = sol.mergeAlternatively(word1, word2);
        System.out.print("Merged String : " +result);
    }
}
