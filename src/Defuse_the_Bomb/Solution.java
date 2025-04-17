package Defuse_the_Bomb;

import java.util.Arrays;

public class Solution {
    public int[] decrypt(int[] code, int k){
        int n = code.length;
        int [] result = new int[n];

        if(k == 0) return result;

        int sum = 0;

        if(k > 0){
            for(int i = 1; i <= k; i++){
                sum += code[i % n];
            }
            for(int i = 0; i < n; i++){
                result[i] = sum;
                sum -= code[(i + 1) % n];
                sum += code[(i + 1 + k) % n];
            }
        } else {
            k = -k;

            for (int i = 1; i <= k; i++) {
                sum += code[(n - i) % n];
            }

            for (int i = 0; i < n; i++) {
                result[i] = sum;
                sum -= code[(n + i - k) % n];
                sum += code[(n + i) % n];
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int [] code = {5, 7, 1, 4};
        int k = 3;

        Solution sol = new Solution();

        int [] result = sol.decrypt(code, k);

        System.out.print("The decrypted code is : "+ Arrays.toString(result));
    }
}
