package Find_Minimum_in_rotated_sorted_array;

// Given a nums = [3, 4, 5, 1, 2] and we have to find a minimum value lies inside array
// so we follow a two pointer approach until left index is less than the right index
// and then find the mid if the value written at mid index is greater than the value
// written at right index then we move forward left index to mid + 1 otherwise move right index to right


public class Solution {
    public static int findMin(int[] nums){
        int left = 0;
        int right = nums.length - 1;

        while(left < right){
            int mid = left + (right - left)/2;
            if(nums[mid] > nums[right]){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
    public static void main(String[] args) {
        int [] nums = {3, 4, 5, 1, 2};
        Solution sol = new Solution();
        int result = sol.findMin(nums);
        System.out.println("The minimum value inside the given array is : " + result);
    }
}
