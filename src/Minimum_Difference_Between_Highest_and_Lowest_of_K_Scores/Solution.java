package Minimum_Difference_Between_Highest_and_Lowest_of_K_Scores;

import java.util.Arrays;

/*
    You are given a 0-indexed integer array nums, where nums[i] represents the score of the ith student.
    You are also given an integer k.

    Pick the scores of any k students from the array so that the difference between the highest
    and the lowest of the k scores is minimized.

    Return the minimum possible difference.

    nums = [9, 4, 1, 7] and k = 2
 */
public class Solution {
    public int minDifference(int [] nums, int k){
        if(k == 1) return 0;

        int minDiff = Integer.MAX_VALUE;
        Arrays.sort(nums);  // Array becomes [1, 4, 7, 9]

        for(int i = 0; i <= nums.length - k; i++){
            int diff =  nums[i + k - 1] - nums[i];
            minDiff = Math.min(diff, minDiff);
        }

        return minDiff;
    }
    public static void main(String[] args) {
        int [] nums = {9, 4, 1, 7};
        int k = 2;
        Solution sol = new Solution();
        System.out.print("The difference is : " + sol.minDifference(nums, k));
    }
}
