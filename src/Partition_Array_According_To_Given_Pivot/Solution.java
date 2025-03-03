package Partition_Array_According_To_Given_Pivot;

import java.util.*;

public class Solution {
    public static int[] pivotArray(int [] nums, int pivot){

        List<Integer> smaller = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();

        for(int num:nums){
            if(num < pivot){
                smaller.add(num);
            } else if(num == pivot){
                equal.add(num);
            } else{
                greater.add(num);
            }
        }

        int index = 0;

        for(int num:smaller) nums[index++] = num;
        for(int num:equal) nums[index++] = num;
        for(int num:greater) nums[index++] = num;

        return nums;
    }
    public static void main(String[] args) {
        int [] nums = {9, 12, 5, 10, 14, 3, 10};
        int pivot = 10;

        System.out.print(Arrays.toString(pivotArray(nums, pivot)));
    }
}
