package Kth_Largest_Element_in_the_array;

import java.util.PriorityQueue;

public class Solution {
    public static int findKthElement(int[] nums, int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        for(int num : nums){
            minHeap.offer(num);

            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
    public static void main(String[] args) {
        int [] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;

        Solution sol = new Solution();

        System.out.println("The kth largest element in the array is : " + findKthElement(nums, k));
    }
}
