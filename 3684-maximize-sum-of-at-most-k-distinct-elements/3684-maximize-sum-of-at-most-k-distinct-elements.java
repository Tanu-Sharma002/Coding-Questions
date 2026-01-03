class Solution {
    public int[] maxKDistinct(int[] nums, int k) {
        Arrays.sort(nums); 
        List<Integer> result = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0 && result.size() < k; i--) {
            if (result.isEmpty() || result.get(result.size() - 1) != nums[i]) {
                result.add(nums[i]);
            }
        }
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }
}
