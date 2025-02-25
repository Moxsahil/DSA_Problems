package Ransom_Note;

import java.util.*;

public class Solution {
    public static boolean isPossible(String ransomNote, String magazine){

        Map<Character ,Integer> charCount = new HashMap<>();

        for(char c : magazine.toCharArray()){
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        for(char c : ransomNote.toCharArray()){
            if(!charCount.containsKey(c) || charCount.get(c) == 0){
                return false;
            }
            charCount.put(c , charCount.get(c) - 1);
        }
        return true;
    }
    public static void main(String[] args) {
        String ransomNote = "ab";
        String magazine = "aab";

        boolean result = isPossible(ransomNote, magazine);

        if(result){
            System.out.println("Yes, it is possible to create note");
        } else {
            System.out.println("No, it is not possible to create note");
        }

    }
}
