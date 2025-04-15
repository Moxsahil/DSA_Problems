package Sort_Array_By_Parity;

/*
    --> Given an integer array nums, move all the even integers at the beginning of the
        array followed by all the odd integers.

    --> Return any array that satisfies this condition.
 */
import java.util.Arrays;

public class Solution {
    public int[] sortArrayByParity(int[] nums){
        int i = 0;
        for(int j=0; j< nums.length; j++){
            if(nums[j] % 2 == 0){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
            }
        }
        return nums;
    }
    public static void main(String[] args) {
        int [] nums = {3, 1, 2, 4};
        Solution sol = new Solution();

        int[] result = sol.sortArrayByParity(nums);

        System.out.print("The sorted array where even value comes before than odd values : " + Arrays.toString(result));
    }
}
