package Subsequence;

import java.util.Scanner;

public class Solution {
    public static boolean isSubsequence(String s, String t){
        int sPointer = 0;
        int tPointer = 0;

        while(sPointer < s.length() && tPointer < t.length()){
            if(s.charAt(sPointer) == t.charAt(tPointer)){
                sPointer++;
            }
            tPointer++;
        }
        return sPointer == s.length();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string : ");
        String s = sc.next();
        System.out.print("Enter second string : ");
        String t = sc.next();
        System.out.println("String entered by you is : " + isSubsequence(s, t));
    }
}
