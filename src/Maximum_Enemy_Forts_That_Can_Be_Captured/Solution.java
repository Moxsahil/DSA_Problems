package Maximum_Enemy_Forts_That_Can_Be_Captured;

/*
    -> You are given a 0-indexed integer array forts of length n representing the positions of several forts.
       forts[i] can be -1, 0, or 1 where:
      * -> -1 represents there is no fort at the ith position.
      # -> 0 indicates there is an enemy fort at the ith position.
      & -> 1 indicates the fort at the ith the position is under your command.
        Now you have decided to move your army from one of your forts at position i to an empty position j
        such that: 0 <= i, j <= n - 1
    The army travels over enemy forts only. Formally, for all k where min(i,j) < k < max(i,j), forts[k] == 0.
    While moving the army, all the enemy forts that come in the way are captured.
    Return the maximum number of enemy forts that can be captured. In case it is impossible to move your army, or
    you do not have any fort under your command, return 0.
 */
public class Solution {
    public int captureForts(int[] forts){
        int n = forts.length;
        int maxNum = 0;

        int left = -1;
        for(int right = 0; right < n; right++){
            if(forts[right] == 0) continue;
            if(left != -1 && forts[left] != forts[right]){
                maxNum = Math.max(maxNum, right - left - 1);
            }
            left = right;
        }
        return maxNum;
    }
    public static void main(String[] args) {
        int [] forts = {1, 0, 0, -1, 0, 0, 0, 0, 1};
        Solution sol = new Solution();

        System.out.print("The maximum number of forts that is captured are : " + sol.captureForts(forts));
    }
}
