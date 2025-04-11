package Find_The_Duplicate_Number;

/*
    --> Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
    There is only one repeated number in nums, return this repeated number.
    You must solve the problem without modifying the array nums and using only constant extra space.

    Approach -> Floyd,s cycle detection algorithm
    we will treat the array as Linked List where -->
    --> nums[i] represents a pointer to next index (like a node pointing to nums[nums[i]] )
    --> due to the duplicate number , there a cycle in this Linked List

   Time Complexity = O(n)
   Space Complexity = O(1)
*/
public class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        fast = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
    public static void main(String[] args) {
        int [] nums = {1, 3, 4, 2, 2};

        Solution sol = new Solution();

        System.out.print("The duplicate number present inside the array is : " + sol.findDuplicate(nums));
    }
}
