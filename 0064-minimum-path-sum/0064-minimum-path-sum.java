class Solution {
    public int minPathSum(int[][] grid) {
        int x=grid.length;
        int y=grid[0].length;
        int dp[][] = new int[x+1][y+1];
        for(int i=0; i<x; i++){
            for(int j=0; j<y; j++){
                if(i==0 && j==0) dp[0][0]=grid[0][0];
                else if(i==0 && j != 0){
                    dp[i][j]=grid[i][j]+dp[i][j-1];
                }
                else if(j==0 && i != 0){
                    dp[i][j]=grid[i][j]+dp[i-1][j];
                } else {
                    dp[i][j]=Math.min(dp[i-1][j]+grid[i][j], dp[i][j-1]+grid[i][j]);
                }
            }
        }
        return dp[x-1][y-1];
    }
}