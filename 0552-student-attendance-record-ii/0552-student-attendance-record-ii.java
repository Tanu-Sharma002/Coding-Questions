class Solution {
    int dp[][][];
    int Mod=1000000007;
    public int checkRecord(int n) {
        dp = new int[n+1][2][3];
        for(int i=0; i<n; i++){
            for(int j=0; j<2; j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return helper(0,n,0,0);
    }
    int helper(int i, int n, int ab, int l){
        if(i>=n) return 1;
        if(dp[i][ab][l] != -1) return dp[i][ab][l];
        long c1=helper(i+1, n, ab, 0);
        long c2=0;
        long c3=0;
        if(ab==0){
            c2=helper(i+1,n,ab+1,0);
        }
        if(l<2){
            c3=helper(i+1, n, ab, l+1);
        }
        return dp[i][ab][l]=(int)((c1+c2+c3)%Mod);
    }
}