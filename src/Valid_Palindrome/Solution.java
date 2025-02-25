package Valid_Palindrome;

import java.util.Scanner;

public class Solution {
    public static boolean validPalindrome(String s){
        if(s == null || s.isEmpty()){
            return false;
        }

        s=s.toLowerCase().replaceAll("[^a-z0-9]","");
        int left = 0;
        int right = s.length()-1;

        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right++;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your String to check : ");
        String s = sc.next();
//        String s = "A man, a plan, a canal: Panama";
        System.out.println(validPalindrome(s));
    }
}
