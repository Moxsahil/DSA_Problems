package Find_First_and_Last_Position_Occurence_of_Element;

//nums = [5, 7, 7, 8, 8, 10]
//target = 8
// return the first and last position at which index it occurs equals to target

import java.util.Arrays;

public class Solution {
    public static int[] findPosition(int [] nums, int target){
        int [] result = new int [2];
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        return result;
    }
    private static int findFirst(int[] nums , int target){
        int index = -1;
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;

            if(nums[mid] == target){
                index = mid;
                right  = mid - 1;
            } else if(nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return index;
    }

    private static int findLast(int[] nums , int target){
        int index = -1;
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;

            if(nums[mid] == target){
                index = mid;
                left  = mid + 1;
            } else if(nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return index;
    }
    public static void main(String[] args) {
        int [] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;

        Solution sol = new Solution();

        int[] result = sol.findPosition(nums, target);

        System.out.println("The First and last occurance of target elemetn is : " + Arrays.toString(result));
    }
}
