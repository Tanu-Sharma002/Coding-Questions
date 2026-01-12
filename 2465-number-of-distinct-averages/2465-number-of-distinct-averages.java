class Solution {
    public int distinctAverages(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums);
        int start=0;
        int end=nums.length-1;
        while(start<end){
            set.add((nums[start]+nums[end]));
            start++;
            end--;
        }
        return set.size();
    }
}