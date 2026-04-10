class Solution {
    Integer dp[];
    int function(int i, int[] nums) {
        int n = nums.length;
        if (i>=n-1) return 0;
        if (dp[i] != null) return dp[i];
        int maxJump = nums[i];
        int minJumps = 10001;
        for (int jump=1; jump<=maxJump; jump++) {
            int ans = function(i+jump, nums); 
            if (ans!=10001) {
                minJumps = Math.min(minJumps, 1 + ans);
            }
        }
        return dp[i] = minJumps;
    }
    public int jump(int[] nums) {
        dp = new Integer[nums.length];
        return function(0, nums);
    }
}