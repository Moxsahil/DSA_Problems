package Maximum_Gap;

/*
 --> Find min & max values: Determine the smallest (minVal) and largest (maxVal) elements in nums.
 --> Edge Case: If there are fewer than 2 elements, return 0.
 --> Compute bucket size and count:
    * Use bucketSize = max(1, (maxVal - minVal) / (N - 1)) to determine the ideal bucket range.
    * Number of buckets: bucketCount = (maxVal - minVal) / bucketSize + 1.
 --> Place elements in buckets:
    * Each bucket stores minimum and maximum values of elements that fall within its range.
 --> Compute the maximum gap:
    * The maximum gap must occur between buckets (since elements within a bucket are close together).
    * Iterate through the buckets, tracking the max difference between adjacent bucket min/max values.

    Time complexity - O(n) because we are using bucket sort(radix sort inspired approach)
    Space Complexity - O(n) for extra space
 */
import java.util.Arrays;

class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2) return 0;

        int minVal = Arrays.stream(nums).min().getAsInt();
        int maxVal = Arrays.stream(nums).max().getAsInt();

        int bucketSize = Math.max(1, (maxVal - minVal) / (n - 1));
        int bucketCount = (maxVal - minVal) / bucketSize + 1;

        int[] bucketMin = new int[bucketCount];
        int[] bucketMax = new int[bucketCount];
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        boolean[] hasValue = new boolean[bucketCount];

        for (int num : nums) {
            int bucketIndex = (num - minVal) / bucketSize;
            bucketMin[bucketIndex] = Math.min(bucketMin[bucketIndex], num);
            bucketMax[bucketIndex] = Math.max(bucketMax[bucketIndex], num);
            hasValue[bucketIndex] = true;
        }

        int maxGap = 0;
        int prevMax = minVal;

        for (int i = 0; i < bucketCount; i++) {
            if (!hasValue[i]) continue;

            maxGap = Math.max(maxGap, bucketMin[i] - prevMax);
            prevMax = bucketMax[i];
        }

        return maxGap;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = {3, 6, 9, 1};
        int[] nums2 = {10};

        System.out.println(sol.maximumGap(nums1));
        System.out.println(sol.maximumGap(nums2));
    }
}

