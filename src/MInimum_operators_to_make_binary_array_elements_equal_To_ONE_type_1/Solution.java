package MInimum_operators_to_make_binary_array_elements_equal_To_ONE_type_1;
/*
You are given a binary array nums.

You can do the following operation on the array any number of times (possibly zero):

Choose any 3 consecutive elements from the array and flip all of them.
Flipping an element means changing its value from 0 to 1, and from 1 to 0.

Return the minimum number of operations required to make all elements in nums equal to 1. If it is impossible, return -1.



Example 1:

Input: nums = [0,1,1,1,0,0]

Output: 3

Explanation:
We can do the following operations:

Choose the elements at indices 0, 1 and 2. The resulting array is nums = [1,0,0,1,0,0].
Choose the elements at indices 1, 2 and 3. The resulting array is nums = [1,1,1,0,0,0].
Choose the elements at indices 3, 4 and 5. The resulting array is nums = [1,1,1,1,1,1].
 */
public class Solution {
    public  int minStep(int [] nums){
        int n = nums.length;
        int operations = 0;

        for (int i = 0; i <= n - 3; i++) {
            if (nums[i] == 0) {
                flip(nums, i);
                operations++;
            }
        }

        for (int num : nums) {
            if (num == 0) {
                return -1;
            }
        }
        return operations;
    }

    private static void flip(int[] nums, int start) {
        for (int i = start; i < start + 3; i++) {
            nums[i] ^= 1;
        }
    }
    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 1, 0, 0};

        Solution sol = new Solution();

        System.out.println("The required minimum operations to make binary array elements rqual to one are :  " +sol.minStep(nums));
    }

}
