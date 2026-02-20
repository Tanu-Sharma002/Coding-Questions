class Solution {
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
        boolean [][] visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(ifWordExist(board, word, visited, i,j,0)) return true;
            }
        }
        return false;
    }
    public boolean ifWordExist(char[][] board, String word, boolean visited[][], int row, int col, int index){
        if(index==word.length()) return true;
        if(row<0 || col<0 || row==board.length || col==board[0].length || board[row][col] != word.charAt(index) || visited[row][col]){
            return false;
        }
        visited[row][col] = true;
        boolean found = ifWordExist(board, word, visited, row+1, col, index+1) ||
                        ifWordExist(board, word, visited, row-1, col, index+1) ||
                        ifWordExist(board, word, visited, row, col-1, index+1) ||
                        ifWordExist(board, word, visited, row, col+1, index+1);

        visited[row][col] = false;
        return found;
    }
}