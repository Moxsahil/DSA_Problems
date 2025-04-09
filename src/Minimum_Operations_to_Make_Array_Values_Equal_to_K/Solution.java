package Minimum_Operations_to_Make_Array_Values_Equal_to_K;

import java.util.HashSet;
import java.util.Set;

/*
  -> i have solved this problem using single pass uses just a set to track distinct numbers
  -> only stores numbers > k
  -> Time complexity = O(n) one pass through nums
  -> Space complexity = O(d) where is distinct values > k
*/
public class Solution {
        public int minOperations(int[] nums, int k) {
            Set<Integer> set = new HashSet<>();

            boolean hasSmaller = false;

            for(int num : nums){
                if(num < k) hasSmaller = true;
                if(num > k) set.add(num);

            }
            if(hasSmaller) return -1;

            return set.size();
    }
    public static void main(String[] args) {
        int [] nums = {5, 2, 5, 4, 5};
        int k = 2;

        Solution sol = new Solution();

        int result = sol.minOperations(nums , k);

        System.out.print("The minimum operation required to make every element in nums equal to k is : " + result);
    }
}
