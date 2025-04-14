package Reverse_String_2;
/*
    Given a string s and an integer k, reverse the first k characters for every 2k characters counting
    from the start of the string.

    If there are fewer than k characters left, reverse all of them. If there are less than 2k but
    greater than or equal to k characters, then reverse the first k characters and leave the other
    as original.

 */
public class Solution {
    public String reverseStr(String s, int k){
        char [] arr = s.toCharArray();

        for(int i = 0; i < arr.length; i+= 2*k){
            int left = i;
            int right = Math.min(i + k - 1, arr.length - 1);
            reverse(arr, left, right);
        }
        return new String(arr);
    }
    private void reverse(char [] arr, int left , int right){
        while(left < right){
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.print(sol.reverseStr("abcdefg", 2));
    }
}
