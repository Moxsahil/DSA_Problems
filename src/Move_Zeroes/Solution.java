package Move_Zeroes;

/*
    --> Given an integer array nums, move all 0's to the end of it while maintaining the relative
        order of the non-zero elements.

        Note that you must do this in-place without making a copy of the array.
 */
import java.util.Arrays;

public class Solution {
    public void moveZeroes(int[] nums){
        int nonZeroIndex = 0;
        for(int i=0; i< nums.length; i++){
            if(nums[i] != 0){
                int temp = nums[nonZeroIndex];
                nums[nonZeroIndex] = nums[i];
                nums[i] = temp;
                nonZeroIndex++;
            }
        }
    }
    public static void main(String[] args) {
        int [] nums = {0, 1, 0, 3, 12};
        Solution sol = new Solution();
        sol.moveZeroes(nums);
        System.out.print("The array after moving all zeroes are : " + Arrays.toString(nums));
    }
}
