class Solution {
    public int longestOnes(int[] nums, int k) {
        int i=0,j=0,count0=0,maxlen=0;
        while(j<nums.length){
            if(nums[j]==0) count0++;
            while(count0>k){
                if(nums[i]==0) count0--;
                i++;
            }
            maxlen=Math.max(maxlen,j-i+1);
            j++;
        }
        return maxlen;
    }
}