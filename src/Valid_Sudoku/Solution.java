package Valid_Sudoku;

import java.util.*;

public class Solution {
    public static boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new Set[9];
        Set<Character>[] cols = new Set[9];
        Set<Character>[] boxes = new Set[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char num = board[r][c];
                if (num == '.') continue;

                int boxIndex = (r / 3) * 3 + (c / 3);

                System.out.printf("Checking cell (%d, %d) with value '%c'\n", r, c, num);
                System.out.printf("Row[%d]: %s\n", r, rows[r]);
                System.out.printf("Col[%d]: %s\n", c, cols[c]);
                System.out.printf("Box[%d]: %s\n", boxIndex, boxes[boxIndex]);

                if (rows[r].contains(num) || cols[c].contains(num) || boxes[boxIndex].contains(num)) {
                    System.out.println("Duplicate found! Invalid Sudoku.");
                    return false;
                }

                rows[r].add(num);
                cols[c].add(num);
                boxes[boxIndex].add(num);
                System.out.println("Added successfully.\n");
            }
        }
        System.out.println("Board is valid.");
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        isValidSudoku(board);
    }
}
