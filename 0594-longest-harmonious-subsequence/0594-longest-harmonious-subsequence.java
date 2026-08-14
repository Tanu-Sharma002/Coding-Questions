class Solution {
    public int findLHS(int[] nums) {
        int l=0; 
        int r=0;
        int max=0;
        int temp=0;
        Arrays.sort(nums);
        while(r<nums.length){
            while(nums[r]-nums[l]>1){
                l++;
            }
            if(Math.abs(nums[r]-nums[l])==1){
                temp=r-l+1;
            }else{
                temp=0;
            }
            max=Math.max(temp,max);
            r++;
        }
        return max;
    }
}