class Solution {
    public int minElement(int[] nums) {
        int ans=Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            if(nums[i]>9){
                int n=nums[i];
                int sum=0;
                while(n>0){
                    int r=n%10;
                    sum += r;
                    n /= 10;
                }
                nums[i]=sum;
            }
            ans = Math.min(ans, nums[i]);
        }
        return ans;
    }
}