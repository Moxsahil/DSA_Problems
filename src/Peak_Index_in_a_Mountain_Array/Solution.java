package Peak_Index_in_a_Mountain_Array;

public class Solution {
    /*
    -> Approach used is Binary search
    -> Find that index which contains the highest value inside array
    -> Maintaining the time complexity O(log n) as we are using binary search
    -> Space complexity = O(1) as no extra space is used
*/
        public int peakIndexInMountainArray(int[] arr) {
            int left = 0;
            int right = arr.length - 1;

            while(left <= right){
                int mid = left + (right - left)/2;

                if(arr[mid] < arr[mid + 1]){
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return left;
    }
    public static void main(String[] args) {
        int[] arr = {0, 2, 1, 1};
        Solution sol = new Solution();

        System.out.print("The index in a mountain where value increases to a peak vale and the decrease : " + sol.peakIndexInMountainArray(arr));
    }
}
