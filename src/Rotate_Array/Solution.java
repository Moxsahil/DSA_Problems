package Rotate_Array;

public class Solution {
    public static void rotateArray(int[] nums, int k){
        if(nums.length == 0 || nums == null || k % nums.length == 0){
            return;
        }
        int n = nums.length;
        k = k % n;

        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }

    private static void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;

        rotateArray(nums, k);

        System.out.print("Rotated Array : ");
        for(int num : nums){
            System.out.print(num + " ");
        }
    }
}
