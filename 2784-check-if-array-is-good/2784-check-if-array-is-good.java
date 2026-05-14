class Solution {
    public boolean isGood(int[] nums) {
        int len = nums.length;
        if (len < 2) return false;
        int n = len - 1;
        Arrays.sort(nums);
        if (nums[len - 1] != n || nums[len - 2] != n) return false;
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) return false;
        }
        return true;
    }
}