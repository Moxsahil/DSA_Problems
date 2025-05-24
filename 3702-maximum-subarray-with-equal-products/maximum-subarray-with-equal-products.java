class Solution {
    public int maxLength(int[] nums) {
        int mx = 0;
        int ml = 1;

        for (int x : nums) {
            mx = Math.max(mx, x);
            ml = lcm(ml, x);
        }
        int ans = 0;
        long maxProduct = (long) ml * mx;
        int n = nums.length;

        for (int i = 0; i < n; ++i) {
            long p = nums[i];
            int g = nums[i];
            int l = nums[i];

            if (p == (long) g * l) {
                ans = Math.max(ans, 1);
            }

            for (int j = i + 1; j < n; ++j) {
                p *= nums[j];
                g = gcd(g, nums[j]);
                l = lcm(l, nums[j]);

                if (p == (long) g * l) {
                    ans = Math.max(ans, j - i + 1);
                }
                if (p > maxProduct) {
                    break;
                }
            }
        }
        return ans;
    }

    private int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // public static void main(String[] args) {
    //     int[] nums = {1, 2, 1, 2, 1, 1, 1};

    //     Solution sol = new Solution();

    //     int result = sol.maxLength(nums);

    //     System.out.print("The max length of subarray is : " + result);
    // }
}
