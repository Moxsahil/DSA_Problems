package Search_Insert_Position;

/*
Given a sorted array of distinct integers and a target value, return the index if the target is found.
If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

Input - [1, 3, 5, 6]

Target = 5
*/
public class Solution {
    public static int find(int [] nums , int target){
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){

            int mid = left + (right - left)/2;

            if(nums[mid] == target){
                return mid;
            } else if (nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        int [] nums = {1, 3, 5, 6};
        int target = 2;

        Solution sol = new Solution();

        System.out.println("We Found the target value at index : " + sol.find(nums, target));
    }
}
