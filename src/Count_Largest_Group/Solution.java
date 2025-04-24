package Count_Largest_Group;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int countLargestGroup(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxSize = 0;

        for(int i = 1; i <= n; i++){
            int digitSum = getDigitSum(i);
            map.put(digitSum, map.getOrDefault(digitSum, 0) + 1);
            maxSize = Math.max(maxSize, map.get(digitSum));
        }
        int count = 0;
        for(int freq : map.values()){
            if(freq == maxSize) count++;
        }
        return count;
    }
    private static int getDigitSum(int num){
        int sum = 0;
        while(num > 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
    public static void main(String[] args) {
        int n = 13;
        Solution sol = new Solution();

        System.out.print("The number of groups that have the largest size are : " + countLargestGroup(n));
    }
}
