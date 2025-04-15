package Sort_Array_By_Parity_II;

/*
    --> Given an array of integers nums, half of the integers in nums are odd, and the other half are even.

    --> Sort the array so that whenever nums[i] is odd, i is odd, and whenever nums[i] is even, i is even.

    --> Return any answer array that satisfies this condition.
 */
import java.util.Arrays;

public class Solution {
    public int[] sortArrayByParity2(int [] nums){
        int oddIndex = 1;
        int evenIndex = 0;

        while(evenIndex < nums.length && oddIndex < nums.length){
            if(nums[evenIndex] % 2 == 0){
                evenIndex += 2;
            } else if(nums[oddIndex] % 2 == 1){
                oddIndex += 2;
            } else {
                int temp = nums[evenIndex];
                nums[evenIndex] = nums[oddIndex];
                nums[oddIndex] = temp;

                evenIndex+= 2;
                oddIndex += 2;
            }
        }
        return nums;
    }
    public static void main(String[] args) {
        int [] nums = {4, 2, 5, 7};

        Solution sol = new Solution();

        int [] result = sol.sortArrayByParity2(nums);

        System.out.print("The array after sorting according to given question is : " + Arrays.toString(result));
    }
}
