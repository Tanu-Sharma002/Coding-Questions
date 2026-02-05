class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int i=0, j=0;
        int product=1;
        int count=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        while(j<nums.length){
            product *= nums[j];
            while(product>=k  && j>=i){
                product = product/nums[i];
                i++;
            }
            count += j-i+1;
            j++;
        }
        return count;
    }
}