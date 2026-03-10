class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!rowSet.add(matrix[i][j]) || matrix[i][j] < 1 || matrix[i][j] > n) {
                    return false;
                }
                if (!colSet.add(matrix[j][i]) || matrix[j][i] < 1 || matrix[j][i] > n) {
                    return false;
                }
            }
        }
        return true;
    }
}