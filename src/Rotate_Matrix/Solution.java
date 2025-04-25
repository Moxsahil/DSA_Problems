package Rotate_Matrix;

import java.util.Arrays;

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        System.out.println("Original matrix:");
        printMatrix(matrix);

        System.out.println("\nTransposing the matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                System.out.println("Swapping (" + i + "," + j + ") with (" + j + "," + i + ")");
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
                printMatrix(matrix);
            }
        }

        System.out.println("\nReversing each row:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                System.out.println("Reversing row " + i + ": swapping index " + j + " with " + (n - 1 - j));
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
                printMatrix(matrix);
            }
        }

        System.out.println("\nFinal rotated matrix:");
        printMatrix(matrix);
    }

    private void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        sol.rotate(matrix);
    }
}

