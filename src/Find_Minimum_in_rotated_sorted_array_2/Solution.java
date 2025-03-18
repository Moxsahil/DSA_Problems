package Find_Minimum_in_rotated_sorted_array_2;

/*
The first variant consist of unique element inside array but this one may contain duplicate so the approach is same but
we check more strictly for duplicate value - Two pointer approach
*/
public class Solution {
    public static int findMin(int [] nums){
        int left = 0;
        int right = nums.length - 1;

        while(left < right){
            int mid = left + (right - left)/2;

            if(nums[mid] < nums[right]){
                right = mid;
            } else if(nums[mid] > nums[right]){
                left = mid + 1;
            } else {
                right--;
            }
        }
        return nums[left];
    }
    public static void main(String[] args) {
        int [] nums = {2, 2, -2, 3, 1};

        Solution sol = new Solution();
        int result = sol.findMin(nums);
        System.out.println("The minimum lies inside the array is : " + result);
    }
}
