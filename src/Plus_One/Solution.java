package Plus_One;

import java.util.Arrays;

public class Solution {
    public int [] plusOne(int [] digits){
        int n = digits.length;

        for(int i = n - 1; i >= 0; i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int [] newDigits = new int [n + 1];
        newDigits[0] = 1;
        return newDigits;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();

        int []digits = {1,2,3};

        int [] result = sol.plusOne(digits);
        System.out.println(Arrays.toString(result));
    }
}
