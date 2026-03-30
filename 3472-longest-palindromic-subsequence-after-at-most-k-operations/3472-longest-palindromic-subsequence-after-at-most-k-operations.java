class Solution {
    int dp[][][];
    public int longestPalindromicSubsequence(String s, int k) {
        int n=s.length();
        dp = new int[n][n][k+1];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return helper(0,n-1,k,s);
    }
    int helper(int i, int j, int k, String s){
        int c1;
        int c2;
        int c3;
        int c4;
        if(i>j) return 0;
        if(i==j) return 1;
        if(dp[i][j][k] != -1) return dp[i][j][k];
        int diff=Math.abs(s.charAt(i)-s.charAt(j));
        c1 = Math.min(diff,26-diff);
        c2 = helper(i+1,j,k,s);
        c3 = helper(i,j-1,k,s);
        int ans=Math.max(c2,c3);
        if(c1<=k){
            ans=Math.max(ans,2+helper(i+1,j-1,k-c1,s));
        }
        return dp[i][j][k]=ans;
    }
}