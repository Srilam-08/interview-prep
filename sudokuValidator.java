import java.util.HashSet;

public class Main {

    public static boolean validSolution(int[][] board) {

        // Check all rows and columns
        for (int i = 0; i < 9; i++) {
            HashSet<Integer> rowSet = new HashSet<>();
            HashSet<Integer> colSet = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                int rowVal = board[i][j];
                int colVal = board[j][i];

                // Zeros are invalid
                if (rowVal == 0 || colVal == 0) return false;

                // Check for duplicates in row
                if (!rowSet.add(rowVal)) return false;

                // Check for duplicates in column
                if (!colSet.add(colVal)) return false;
            }
        }

        // Check 3x3 subgrids
        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {
                HashSet<Integer> blockSet = new HashSet<>();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        int val = board[row + i][col + j];
                        if (!blockSet.add(val)) return false; // duplicate in block
                    }
                }
            }
        }

        return true; // All checks passed
    }

    public static void main(String[] args) {

        int[][] validBoard = {
            {5,3,4,6,7,8,9,1,2},
            {6,7,2,1,9,5,3,4,8},
            {1,9,8,3,4,2,5,6,7},
            {8,5,9,7,6,1,4,2,3},
            {4,2,6,8,5,3,7,9,1},
            {7,1,3,9,2,4,8,5,6},
            {9,6,1,5,3,7,2,8,4},
            {2,8,7,4,1,9,6,3,5},
            {3,4,5,2,8,6,1,7,9}
        };

        int[][] invalidBoard = {
            {5,3,4,6,7,8,9,1,2},
            {6,7,2,1,9,0,3,4,8},
            {1,0,0,3,4,2,5,6,0},
            {8,5,9,7,6,1,0,2,0},
            {4,2,6,8,5,3,7,9,1},
            {7,1,3,9,2,4,8,5,6},
            {9,0,1,5,3,7,2,1,4},
            {2,8,7,4,1,9,6,3,5},
            {3,0,0,4,8,1,1,7,9}
        };

        System.out.println("Valid Board: " + validSolution(validBoard));   // true
        System.out.println("Invalid Board: " + validSolution(invalidBoard)); // false
    }
}

//optimized
/*
class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    int boxIndex = (i / 3) * 3 + (j / 3);

                    if (rows[i][num] || cols[j][num] || boxes[boxIndex][num]) {
                        return false;
                    }

                    rows[i][num] = cols[j][num] = boxes[boxIndex][num] = true;
                }
            }
        }
        return true;
    }
}
*/
