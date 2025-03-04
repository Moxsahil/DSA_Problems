package Check_if_Number_is_a_Sum_of_Powers_of_Three;

public class Solution {
    public boolean checkPowersOfThree(int n) {
        while (n > 0) {
            if (n % 3 == 2) return false;
            n /= 3;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 12;
        boolean result = sol.checkPowersOfThree(n);

        System.out.println(result);
    }
}
