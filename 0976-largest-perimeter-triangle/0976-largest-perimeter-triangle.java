class Solution {
    public int largestPerimeter(int[] nums) {
        int sum = 0;
        int Max = 0;
        if (nums.length < 3) return 0;
        Arrays.sort(nums);
        int n = nums.length - 1;
        for (int i = n; i >= 2; i--) {
            int a = nums[i];
            int b = nums[i - 1];
            int c = nums[i - 2];
            if (a < b + c) {
                sum = a + b + c;
            }
            Max = Math.max(sum, Max);
        }
        return Max;
    }
}
