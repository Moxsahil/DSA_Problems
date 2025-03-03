package Transform_Array_by_Parity;

import java.util.Arrays;

public class Solution {
    public static int[] transformAndSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (nums[i] % 2 == 0) ? 0 : 1;
        }

        Arrays.sort(nums);

        return nums;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 3, 2, 1};
        System.out.println(Arrays.toString(transformAndSort(nums1)));

        int[] nums2 = {1, 5, 1, 4, 2};
        System.out.println(Arrays.toString(transformAndSort(nums2)));
    }
}
