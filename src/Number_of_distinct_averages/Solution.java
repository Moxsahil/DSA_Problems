package Number_of_distinct_averages;
/*
    -> You are given a 0-indexed integer array nums of even length.
    -> As long as nums is not empty, you must repetitively:
    -> Find the minimum number in nums and remove it.
    -> Find the maximum number in nums and remove it.
    -> Calculate the average of the two removed numbers.
    -> The average of two numbers a and b is (a + b) / 2.

    -> Return the number of distinct averages calculated using the above process.
 */
import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    public static int findAverage(int [] nums){
        Arrays.sort(nums);
        HashSet<Double> set = new HashSet<>();
        int left = 0;
        int right = nums.length - 1;

        while(left < right){
           double average =  (nums[left] + nums[right])/2.0;
               if(!set.contains(average)){
                   set.add(average);
               }
               left++;
               right--;
        }
        return set.size();
    }

    public static void main(String[] args) {
        int [] nums = {4, 1, 4, 0, 3, 5};

        Solution sol = new Solution();

        System.out.print("The number of distinct averages are : " + sol.findAverage(nums));
    }
}
