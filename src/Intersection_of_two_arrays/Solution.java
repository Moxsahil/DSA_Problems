package Intersection_of_two_arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static int[] intersection(int[] nums1, int[] nums2){
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums1){
            set.add(num);
        }

        Set<Integer> resultSet = new HashSet<>();
        for(int num: nums2){
            if(set.contains(num)){
                resultSet.add(num);
            }
        }
        int[] result = new int[resultSet.size()];
        int i = 0;

        for(int num : resultSet){
            result[i++] = num;
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int [] nums2 = {2, 2};

        Solution sol = new Solution();

        System.out.println("intersection of given arrays : " + Arrays.toString(intersection(nums1, nums2)) );

    }
}
