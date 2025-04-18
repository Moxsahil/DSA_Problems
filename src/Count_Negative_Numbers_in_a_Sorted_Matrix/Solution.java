package Count_Negative_Numbers_in_a_Sorted_Matrix;

public class Solution {
    public int countNegatives(int[][] grid) {
        /*
        The First appraoch is called greedy approach which gives best optimal solution in time complexity in O(m + n) and space complexity
        O(1) but this question is given in binary search problems so 2Nd approach solution is in binary search whose time complexity goes
        to O(m logn) and space complexity O(1)
        */
        /*
        Greedy approach
        int m = grid.length;
        int n = grid[0].length;
        int row =m - 1;
        int col = 0;
        int count = 0;

        while(row >= 0 && col < n){
            if(grid[row][col] < 0){
                count += (n - col);
                row--;
            } else {
                col++;
            }
        }
        return count;
        */
        //2nd approach -> Binary Search
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            int firstNegIndex = BinarySearch(grid[i]);
            if (firstNegIndex != -1) {
                count += (n - firstNegIndex);
            }
        }
        return count;
    }

    private int BinarySearch(int[] row) {
        int left = 0;
        int right = row.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (row[mid] < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left < row.length ? left : -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] grid = {
                {4, 3, 2, -1},
                {3, 2, 1, -1},
                {1, 1, -1, -2},
                {-1, -1, -2, -3}
        };

        int result = sol.countNegatives(grid);
        System.out.println("Number of negative numbers in the grid: " + result);
    }
}
