package Spiral_Matrix;

import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            System.out.println("Traversing top row from left to right:");
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
                System.out.println("Added: " + matrix[top][i]);
            }
            top++;
            System.out.println("top incremented to: " + top);

            System.out.println("Traversing right column from top to bottom:");
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
                System.out.println("Added: " + matrix[i][right]);
            }
            right--;
            System.out.println("right decremented to: " + right);

            if (top <= bottom) {
                System.out.println("Traversing bottom row from right to left:");
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                    System.out.println("Added: " + matrix[bottom][i]);
                }
                bottom--;
                System.out.println("bottom decremented to: " + bottom);
            }

            if (left <= right) {
                System.out.println("Traversing left column from bottom to top:");
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                    System.out.println("Added: " + matrix[i][left]);
                }
                left++;
                System.out.println("left incremented to: " + left);
            }
        }

        System.out.println("Final spiral order: " + result);
        return result;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        sol.spiralOrder(matrix);
    }
}

