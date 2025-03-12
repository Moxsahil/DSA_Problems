package Maximum_Count_of_Positive_Integer_and_Negative_Integer;

/*

    Given an array nums sorted in non-decreasing order, return the maximum between the number of positive
    integers and the number of negative integers.
    return the maximum of pos and neg.

    Note that 0 is neither positive nor negative.
*/
public class Solution {
    public static int maximumCount(int [] nums){
        int n =  nums.length;

        int posIndex = findpostiveCount(nums);
        int negIndex = findNegativeCount(nums);

        int posCount = n - posIndex;
        int negCount = negIndex;

        return Math.max(posCount, negCount);
    }

    private static int findpostiveCount(int [] nums){
        int left = 0;
        int right = nums.length;

        while(left < right){
            int mid = left + (right - left)/2;
            if(nums[mid] > 0){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    private static int findNegativeCount(int [] nums){
        int left = 0;
        int right = nums.length;

        while(left < right){
            int mid = left + (right - left)/2;
            if(nums[mid] < 0){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        int [] nums = {-2, -1, -1, 0, 1, 2, 3};
        int [] nums2 = {-3, -2, -1, 0, 0, 1, 2, 3, 5};

        Solution sol = new Solution();

        System.out.println("The maximum count between + and - number is : " + sol.maximumCount(nums));
        System.out.println("The maximum count between + and - number is : " + sol.maximumCount(nums2));
    }
}
