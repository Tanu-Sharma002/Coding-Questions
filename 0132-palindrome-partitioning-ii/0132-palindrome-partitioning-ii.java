class Solution {
    public int minCut(String s) {
        int n=s.length();
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        return solve(0,s,dp,n)-1;
    }
    public int solve(int i,String s,int dp[],int n){
        if(i>=s.length()) return 0;
        if(dp[i] != -1) return dp[i];
        int ans=Integer.MAX_VALUE;
        for(int j=i; j<n; j++){
            if(palindrome(i,j,s)){
                int cost=1+solve(j+1,s,dp,n);
                ans=Math.min(cost,ans);
            }
        }
        return dp[i]=ans;
    }
    boolean palindrome(int i,int j,String s){
        while(i<j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}