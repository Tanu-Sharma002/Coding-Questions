class Solution {
    public int countPartitions(int[] nums) {
        int p=0;
        int total_sum=0;
        for(int i=0; i<nums.length; i++){
            total_sum += nums[i];
        }
        int sums=total_sum;
        int lsum=0;
        for(int i=0; i<nums.length-1; i++){
            lsum += nums[i];
            total_sum -= nums[i];
            if(Math.abs(lsum-total_sum)%2 ==0) p++;
        }
        return p;
    }
}