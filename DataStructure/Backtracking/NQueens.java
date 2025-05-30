package DataStructure.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//pseudocode
// function solveNQueens(n):
//     result = empty list to store all board solutions
//     board = char[n][n] initialized with '.'

//     backtrack(row = 0)

//     return result

// function backtrack(row):
//     if row == n:
//         add a copy of board as list of strings to result
//         return

//     for col in 0 to n - 1:
//         if col is not in columns and (row + col) not in diag1 and (row - col + n - 1) not in diag2:
//             place 'Q' at board[row][col]
//             mark col, diag1, diag2 as used

//             backtrack(row + 1)

//             remove 'Q' from board[row][col]  // backtrack
//             unmark col, diag1, diag2

public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        boolean[] columns = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1];
        boolean[] diag2 = new boolean[2 * n - 1];
        backtrack(0, n, board, result, columns, diag1, diag2);
        return result;

    }

    private void backtrack(int row, int n, char[][] board, List<List<String>> result,
                           boolean[] columns, boolean[] diag1, boolean[] diag2) {
        if (row == n) {
            result.add(constructBoard(board));
            return;
        }

        for(int col =0; col < n; col++) {
            if(col)
        }
    }

    private List<String> constructBoard(char[][] board) {
        List<String> result = new ArrayList<>();
        for (char[] row : board) {
            result.add(new String(row));
        }
        return result;
    }
}
