package Find_The_Peak_Element;
/*
Given a array in which we have to find the peak element and return the index where the peak element is spotted
for that we have to use binary approach for maintaining the O(log n) complexity(given with query)
*/
public class Solution {
    public static int peakElement(int[] nums){
        int left = 0;
        int right = nums.length - 1;

        while(left < right){
            int mid = left + (right - left)/2;
            if(nums[mid] > nums[mid + 1]){
                right = mid ;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        int [] nums = {1, 2, 3, 1};
        int [] nums2 = {1, 2, 1, 3, 5, 6, 4};
        Solution sol = new Solution();

        int result = sol.peakElement(nums2);
        System.out.println("The peak element is : " + result);
    }
}
