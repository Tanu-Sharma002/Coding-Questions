class Solution {
    public int knightDialer(int n) {
        int mod=1000000007;
        int [][] moves={{4,6},{6,8},{7,9},{4,8},{0,3,9},{},{0,1,7},{2,6},{1,3},{2,4}};
        long[] dp=new long[10];
        for(int i=0; i<10; i++) dp[i]=1;
        for(int i=2; i<=n; i++){
            long[] next=new long[10];
            for(int j=0; j<10; j++){
                for(int ngh:moves[j]){
                    next[j]=(next[j]+dp[ngh])%mod;
                }
            }
            dp=next;
        }
        long sum=0;
        for(long val:dp){
            sum = (sum+val)%mod;
        }
        return (int)sum;
    }
}