class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        Integer[][] dp = new Integer[n][2];
        int res =helper(0,0,fee,prices,n,dp);
        return res;
    }
    public static int helper(int i, int buy, int fee, int prices[],int n,Integer dp[][]){
        if(i>=n) return 0;
        if(dp[i][buy] != null) return dp[i][buy];
        int c1;
        int c2;
        if(buy==0){
            c1=-prices[i]+helper(i+1,1,fee,prices,n,dp);
            c2=helper(i+1,0,fee,prices,n,dp);
        } else {
            c1=prices[i]-fee+helper(i+1,0,fee,prices,n,dp);
            c2=helper(i+1,1,fee,prices,n,dp);
        }
        return dp[i][buy]=Math.max(c1,c2);
    }
}
