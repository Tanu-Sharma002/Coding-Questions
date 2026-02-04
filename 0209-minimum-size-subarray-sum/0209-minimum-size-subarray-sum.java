class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            sum += nums[j];
            j++;
            while (sum >= target) {
                ans = Math.min(ans, j - i);
                sum -= nums[i];
                i++;
            }
        }
        if (ans == Integer.MAX_VALUE) {
            return 0;
        }
        return ans;
    }
}
