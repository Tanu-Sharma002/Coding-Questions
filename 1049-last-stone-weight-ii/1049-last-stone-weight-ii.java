class Solution {
    public int lastStoneWeightII(int[] stones) {
        int t_sum=0;
        for(int i=0; i<stones.length; i++){
            t_sum += stones[i];
        }
        int sum = t_sum/2;
        boolean dp[] = new boolean[sum+1];
        dp[0]=true;
        for(int i=0; i<stones.length; i++){
            for(int j=sum; j>=stones[i]; j--){
                dp[j]=dp[j] || dp[j-stones[i]];
            }
        }
        for (int j = sum; j >= 0; j--) {
            if (dp[j]) {
                return t_sum - 2 * j;
            }
        }
        return 0;
    }
}