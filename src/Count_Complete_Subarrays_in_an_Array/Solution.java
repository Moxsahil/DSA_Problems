package Count_Complete_Subarrays_in_an_Array;

import java.util.*;

public class Solution {

    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;

        Set<Integer> totalDistinctSet = new HashSet<>();
        for (int num : nums) {
            totalDistinctSet.add(num);
        }
        int totalDistinct = totalDistinctSet.size();
        System.out.println("Total Distinct Elements in Array: " + totalDistinct);

        int count = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();
        int left = 0;

        for (int right = 0; right < n; right++) {
            freqMap.put(nums[right], freqMap.getOrDefault(nums[right], 0) + 1);
            System.out.println("Window [" + left + "," + right + "] - Added: " + nums[right] + " → freqMap: " + freqMap);

            while (freqMap.size() == totalDistinct) {
                count += n - right;
                System.out.println("Complete subarray found from [" + left + "," + right + "], count += " + (n - right) + " → Total: " + count);

                freqMap.put(nums[left], freqMap.get(nums[left]) - 1);
                if (freqMap.get(nums[left]) == 0) {
                    freqMap.remove(nums[left]);
                }
                System.out.println("Shrinking window: Removed " + nums[left] + " → freqMap: " + freqMap);
                left++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = {1, 3, 1, 2, 2};
        System.out.println("Final Count: " + sol.countCompleteSubarrays(nums));
    }
}

