package Max_Numbers_of_K_sum_Pairs;

import java.util.HashMap;

public class Solution {
    public static int operations(int[] nums, int k){
        int operations = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            int complement = k - num;

            if(map.getOrDefault(complement, 0) > 0){
                operations++;
                map.put(complement, map.get(complement) - 1);
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        return operations;
    }
    public static void main(String[] args) {
        int [] nums = {1, 2, 3, 4};
        int k = 5;

        Solution sol = new  Solution();

        int result = sol.operations(nums, k);
        System.out.println("The max operations we can perform to get resultant sum value equivalent to K : " + result);
    }
}
