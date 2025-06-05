package Algorithms.Backtracking;

public class WordSearch {

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (backtrack(board, word, row, col, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int row, int col, int index, boolean[][] visited) {
        if (index == word.length())
            return true;
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length ||
                visited[row][col] || board[row][col] != word.charAt(index)) {
            return false;
        }
        visited[row][col] = true;
        boolean found = backtrack(board, word, row + 1, col, index + 1, visited) ||
                backtrack(board, word, row - 1, col, index + 1, visited) ||
                backtrack(board, word, row, col + 1, index + 1, visited) ||
                backtrack(board, word, row, col - 1, index + 1, visited);
        visited[row][col] = false;
        return found;
    }
}
