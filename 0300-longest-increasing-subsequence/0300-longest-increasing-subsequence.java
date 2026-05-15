/* 
// Through memoization
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp,1);
        int max=1;
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(nums[i]>nums[j]) 
                    dp[i] = Math.max(dp[i],dp[j]+1);
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}                       

*/

// recursive approach with memoization
class Solution {
    public int lengthOfLIS(int[] nums) {
        int ans=0;
        int dp[] = new int[2501];
        Arrays.fill(dp,-1);
        for(int i=0; i<nums.length; i++){
            ans = Math.max(ans,helper(nums,i,dp));
        }
        return ans;
    }
    public static int helper(int arr[], int i, int dp[]){
        if(dp[i] != -1) return dp[i];
        int ans=1;
        for(int j=0; j<i; j++){
            if(arr[i]>arr[j]) ans=Math.max(ans,helper(arr,j,dp)+1);
        }
        return dp[i]=ans;
    }
}

//
