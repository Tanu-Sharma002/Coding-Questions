class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max=nums[0];
        for(int i=0; i<nums.length; i++){
            max=Math.max(nums[i],max);
        }
        int i=0,j=0,count=0;
        long len=0;
        while(j<nums.length){
            if(nums[j]==max) count++;
            while(count>=k){
                if(nums[i]==max) count--;
                len += nums.length-j;
                i++;
            }
            j++; 
        }
        return len;
    }
}