package Max_Consecutive_Ones;

public class Solution {
    public int maxConsecutiveOnes3(int[] nums, int k){
        int maxLength = 0;
        int zeroes = 0;

        int left = 0;
        for(int right = 0; right < nums.length; right++){
            if(nums[right] == 0){
                zeroes++;
            }

            while( zeroes > k){
                if(nums[left] == 0){
                    zeroes--;
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;

        Solution sol = new Solution();

        System.out.print("The length of max consective ones : " + sol.maxConsecutiveOnes3(nums, k));
    }
}
