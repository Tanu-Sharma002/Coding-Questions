class Solution {
    
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        Integer[][][] dp = new Integer[n][2][k + 1];
        int res =helper(0,0,k,0,prices,n,dp);
        return res;
    }
    public static int helper(int i, int buy, int k, int t, int prices[],int n,Integer dp[][][]){
        if(i==n || t==k) return 0;
        if(dp[i][buy][t] != null) return dp[i][buy][t];
        int c1;
        int c2;
        if(buy==0){
            c1=-prices[i]+helper(i+1,1,k,t,prices,n,dp);
            c2=helper(i+1,0,k,t,prices,n,dp);
        } else {
            c1=prices[i]+helper(i+1,0,k,t+1,prices,n,dp);
            c2=helper(i+1,1,k,t,prices,n,dp);
        }
        return dp[i][buy][t]=(Math.max(c1,c2));
    }
}
