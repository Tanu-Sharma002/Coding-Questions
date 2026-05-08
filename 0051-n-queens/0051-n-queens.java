import java.util.*;

class Solution {
    static private boolean isSafe(String[][] board, int row, int col, int n) {
        int i, j;
        for (i = 0; i < row; i++) {
            if (board[i][col].equals("Q")) return false;
        }

        // Check upper-left diagonal
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j].equals("Q")) return false;
        }

        // Check upper-right diagonal
        for (i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board[i][j].equals("Q")) return false;
        }
        return true;
    }

    static private void addSolution(String[][] board, int n, List<List<String>> ans) {
        List<String> currentAnswer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder rowStr = new StringBuilder();
            for (int j = 0; j < n; j++) {
                rowStr.append(board[i][j]);
            }
            currentAnswer.add(rowStr.toString());
        }
        ans.add(currentAnswer);
    }

    static private void solveNQueensHelper(String[][] board, int row, int n,List<List<String>> ans) {
        if (row >= n) {
            addSolution(board, n, ans);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isSafe(board, row, i, n)) {
                board[row][i] = "Q";
                solveNQueensHelper(board, row + 1, n, ans);
                board[row][i] = ".";
            }
        }
    }

    public static List<List<String>> solveNQueens(int n) {
        String[][] board = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = ".";
            }
        }
        List<List<String>> ans = new ArrayList<>();
        solveNQueensHelper(board, 0, n, ans);
        return ans;
    }
}
