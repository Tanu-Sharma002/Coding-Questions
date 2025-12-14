class Solution {
    public int absDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int smallestSum=0;
        int largestSum=0;
        int end = nums.length-1;
        for(int i=0; i<k; i++){
            smallestSum += nums[i];
        }
        for(int i=0; i<k; i++){
            largestSum += nums[end];
            end--;
        }
        return(Math.abs(largestSum-smallestSum));
    }
}