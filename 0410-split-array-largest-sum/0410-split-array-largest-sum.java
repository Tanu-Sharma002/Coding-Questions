class Solution {
    public int splitArray(int[] nums, int k) {
        return findWays(nums, nums.length,k);
    }
    private static int countArrays(int nums[], int sum){
        int count=1;
        int array=0;
        for(int i=0; i<nums.length; i++){
            if(array+nums[i]<=sum){
                array += nums[i];
            } else {
                count++;
                array = nums[i];
            }
        }
        return count;
    }
    private static int findWays(int nums[], int n, int m){
        if(m>n) return -1;
        int low=nums[0];
        int high=0;
        for(int x:nums){
            low=Math.max(low,x);
            high += x;
        }
        while(low<=high){
            int mid=(low+high)/2;
            int arrays=countArrays(nums,mid);
            if(arrays>m) low=mid+1;
            else high=mid-1;
        }
        return low;
    }
}