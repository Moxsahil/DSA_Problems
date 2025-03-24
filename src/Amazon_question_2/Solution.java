package Amazon_question_2;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'findOptimalLevel' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY inventoryLevels
     *  2. INTEGER x
     *  3. INTEGER y
     */

    public static int findOptimalLevel(List<Integer> inventoryLevels, int x, int y) {
        // Write your code here
        // int n = inventoryLevels.size();

        // int low = 1;
        // int high = Collections.max(inventoryLevels) + x;

        // while(low < high){
        //     int mid = (low + high +1)/2;

        //     if(canAchieve(inventoryLevels, x, y, mid)){
        //         low = mid;
        //     } else {
        //         high = mid - 1;
        //     }
        // }
        // return low;
        // }

        // private static boolean canAchieve(List<Integer> inventoryLevels, int x, int y, int target){
        //     int n = inventoryLevels.size();
        //     int [] adjustments = new int [n];
        //     int balance = 0;

        //     for(int i=0; i<n; i++){
        //         balance += adjustments[i];

        //         int required = target - (inventoryLevels.get(i) + balance);
        //         if(required > 0){
        //             if(i+1 < n){
        //                 adjustments[i+1] += required;
        //                 balance += required;
        //             } else {
        //                 return false;
        //             }
        //         }
        //     }
        //     return true;

        //  int n = inventoryLevels.size();
        //     int sumInitial = inventoryLevels.stream().mapToInt(Integer::intValue).sum();
        //     int minInitial = Collections.min(inventoryLevels);

        //     int left = minInitial;
        //     int right = (sumInitial / n) + 1_000_000_000; // Upper bound adjusted for binary search
        //     int answer = minInitial;

        //     while (left <= right) {
        //         int mid = left + (right - left) / 2;
        //         if (isFeasible(inventoryLevels, x, y, mid, sumInitial, n)) {
        //             answer = mid;
        //             left = mid + 1;
        //         } else {
        //             right = mid - 1;
        //         }
        //     }
        //     return answer;
        // }

        // private static boolean isFeasible(List<Integer> inventory, int x, int y, int T, int sumInitial, int n) {
        //     long sumA = 0;
        //     long sumB = 0;

        //     for (int num : inventory) {
        //         if (num < T) {
        //             int delta = T - num;
        //             sumA += (delta + x - 1) / x; // Ceiling division
        //         } else {
        //             int delta = num - T;
        //             sumB += delta / y;
        //         }
        //     }

        //     if (sumA > sumB) {
        //         return false;
        //     }

        //     long requiredSum = (long) T * n;
        //     long totalAfter = sumInitial + (x - y) * sumA;

        //     return totalAfter >= requiredSum;

        //  int left = Collections.min(inventoryLevels);
        //     int right = Collections.max(inventoryLevels) + (inventoryLevels.size() * x);

        //     while (left < right) {
        //         int mid = (left + right + 1) / 2;
        //         if (isFeasible(inventoryLevels, x, y, mid)) {
        //             left = mid;
        //         } else {
        //             right = mid - 1;
        //         }
        //     }

        //     return left;
        // }

        // private static boolean isFeasible(List<Integer> inventoryLevels, int x, int y, int target) {
        //     long required = 0;
        //     for (int level : inventoryLevels) {
        //         if (level < target) {
        //             required += (target - level + x - 1) / x;
        //         }
        //     }

        //     long available = 0;
        //     for (int level : inventoryLevels) {
        //         if (level > target) {
        //             available += (level - target) / y;
        //         }
        //     }

        //     return required <= available;

        int n = inventoryLevels.size();
        long sumInitial = inventoryLevels.stream().mapToLong(Integer::longValue).sum();
        int minInitial = Collections.min(inventoryLevels);

        int left = minInitial;
        int right = Integer.MAX_VALUE;
        int answer = minInitial;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isFeasible(inventoryLevels, x, y, mid, sumInitial, n)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }

    private static boolean isFeasible(List<Integer> inventory, int x, int y, int T, long sumInitial, int n) {
        long sumA = 0;
        long sumB = 0;

        for (int num : inventory) {
            if (num < T) {
                long delta = T - num;
                sumA += (delta + x - 1) / x; // Ceiling division
            } else {
                long delta = num - T;
                sumB += delta / y;
            }
        }

        if (sumA > sumB) {
            return false;
        }

        long requiredSum = (long) T * n;
        long totalAfter = sumInitial + (x - y) * sumA;

        return totalAfter >= requiredSum;
    }
}


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int inventoryLevelsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> inventoryLevels = IntStream.range(0, inventoryLevelsCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int x = Integer.parseInt(bufferedReader.readLine().trim());

        int y = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.findOptimalLevel(inventoryLevels, x, y);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}


