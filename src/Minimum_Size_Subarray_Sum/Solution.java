package Minimum_Size_Subarray_Sum;

public class Solution {
    public static int minSubArray(int target, int [] nums){
        int n = nums.length;
        int currentSum = 0;
        int minLength = Integer.MAX_VALUE;
        int i = 0;
        for(int j=0; j<n; j++){
            currentSum += nums[j];

            while(currentSum >= target){
                minLength = Math.min(minLength, j-i+1);
                currentSum -= nums[i];
                i++;
            }
        }
        if(minLength == Integer.MAX_VALUE){
            return 0;
        } else {
            return minLength;
        }

    }
    public static void main(String[] args) {
        int target = 7;
        int [] nums = {2,3,1,2,4,3};

        System.out.println("The minimum size subarray is " + minSubArray(target, nums));
    }
}
