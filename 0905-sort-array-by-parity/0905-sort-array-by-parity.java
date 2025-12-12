class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int end=nums.length;
        int arr[] = new int[end];
        int j=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]%2==0){
                arr[j]=nums[i];
                j++;
            } else {
                arr[end-1]=nums[i];
                end--;
            }
        }
        return arr;
    }
}