class Solution {
    public int specialArray(int[] nums) {
        int count=0;
        for(int i=0; i<=nums.length; i++){
            for(int j=0; j<nums.length; j++){
                if(nums[j]>=i) count++;
            }
            if(count==i) return i;
            else count=0;
        }
        return -1;
    }
}