class Solution {
    public int candy(int[] ratings) {
        int n= ratings.length;
        if(n==0) return 0;
        if(n==1) return 1;
        int[] nums = new int[n];
        Arrays.fill(nums,1);
        for(int i=1; i<n; i++){
            if(ratings[i]>ratings[i-1]){
                nums[i]=nums[i-1]+1 ;
            }
        }
        for(int i=n-2; i>=0; i--){
            if(ratings[i]>ratings[i+1] && nums[i]<=nums[i+1]) {
                nums[i]=nums[i+1]+1 ;
            }
        }
        int sum =0;
        for(int c:nums){
            sum += c;
        }
        return sum ;
    }
}