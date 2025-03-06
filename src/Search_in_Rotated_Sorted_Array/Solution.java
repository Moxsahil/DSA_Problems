package Search_in_Rotated_Sorted_Array;

//int nums = [4, 5, 6, 7, 0 , 1, 2]
//target = 0
//return the index at which we find the target value

public class Solution {
    public static int searchInArray(int [] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;

            if(nums[mid] == target){
                return mid;
            }

            if(nums[left] <= nums[mid]){
                if(nums[left] <= target && target < nums[mid]){
                    right = mid-1;
                } else {
                    left = mid + 1;
                }
            } else {
                if(nums[mid] < target && target <= nums[right]){
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        int [] nums = {4, 5, 6, 7, 0 , 1, 2};
        int target = 0;

        Solution sol = new Solution();

        System.out.println("We found the target value at index : " + sol.searchInArray(nums, target));
    }
}
