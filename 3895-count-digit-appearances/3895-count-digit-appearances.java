class Solution {
    public int countDigitOccurrences(int[] nums, int digit) {
        int count=0;
        
        for(int i=0; i<nums.length; i++){
            if(nums[i]<10 && nums[i]==digit){
                count++;
                continue;
            }
            int x=nums[i];
            while(x>0){
                int r=x%10;
                if(r==digit){
                    count++;
                }
                x = x/10;
            }
        }
        return count;
    }
}