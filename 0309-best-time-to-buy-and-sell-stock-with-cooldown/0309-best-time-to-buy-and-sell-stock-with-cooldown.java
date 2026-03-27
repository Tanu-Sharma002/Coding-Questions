class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        Integer[][] dp = new Integer[n+1][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        int res =helper(0,0,prices,n,dp);
        return res;
    }
    public static int helper(int i, int buy, int prices[],int n,Integer dp[][]){
        if(i>=n) return 0;
        if(dp[i][buy] != -1) return dp[i][buy];
        int c1;
        int c2;
        if(buy==0){
            c1=-prices[i]+helper(i+1,1,prices,n,dp);
            c2=helper(i+1,0,prices,n,dp);
        } else {
            c1=prices[i]+helper(i+2,0,prices,n,dp);
            c2=helper(i+1,1,prices,n,dp);
        }
        return dp[i][buy]=(Math.max(c1,c2));
    }
}