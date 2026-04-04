class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;
        int c=coins.length;
        int dp[][] = new int[c+1][amount+1];
        for(int i=0; i<=c; i++) dp[i][0]=0;
        for(int j=1; j<=amount; j++) dp[0][j]=Integer.MAX_VALUE-1;
        for(int i=1; i<=c; i++){
            for(int j=1; j<=amount; j++){
                if(coins[i-1] <= j) dp[i][j]=Math.min(1+dp[i][j-coins[i-1]],dp[i-1][j]);
                else dp[i][j]=dp[i-1][j];
            }
        }
        int result = dp[c][amount];
        return result >= Integer.MAX_VALUE - 1 ? -1 : result;
    }
}