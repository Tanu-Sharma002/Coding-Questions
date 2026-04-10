class Solution {
    Boolean dp[];
    boolean function(int i, int[] nums) {
        int n = nums.length;
        if (i >= n - 1) return true;
        if (dp[i] != null) return dp[i];
        int maxJump = nums[i];
        if (i + maxJump >= n - 1) return dp[i] = true;
        for (int jump = 1; jump <= maxJump; jump++) {
            if (function(i + jump, nums)) {
                return dp[i] = true; 
            }
        }
        return dp[i] = false;
    }
    public boolean canJump(int[] nums) {
        dp = new Boolean[nums.length];
        return function(0, nums);
    }
}

/*
public boolean canJump(int[] nums) {
    int reachable = 0;
    for(int i = 0; i < nums.length; i ++) {
        if(i > reachable) return false;
        reachable = Math.max(reachable, i + nums[i]);
    } 
    return true;
}
*/