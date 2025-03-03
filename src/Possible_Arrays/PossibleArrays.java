package Possible_Arrays;

import java.util.*;

public class PossibleArrays {
    public static int minCostToRemoveAll(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
        }

        int totalCost = 0;

        while (pq.size() > 3) {
            int first = pq.poll();
            int second = pq.poll();
            totalCost += Math.max(first, second);
        }

        int maxRemaining = 0;
        while (!pq.isEmpty()) {
            maxRemaining = Math.max(maxRemaining, pq.poll());
        }
        totalCost += maxRemaining;

        return totalCost;
    }

    public static void main(String[] args) {
        int[] nums1 = {6, 2, 8, 4};
        System.out.println(minCostToRemoveAll(nums1));

        int[] nums2 = {2, 1, 3, 3};
        System.out.println(minCostToRemoveAll(nums2));
    }
}
