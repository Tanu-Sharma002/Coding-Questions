class Solution {
    public long maxProduct(int[] nums) {
        int arr[] = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            arr[i]=Math.abs(nums[i]);
        }
        int n=arr.length;
        Arrays.sort(arr);
        long ans=(long)arr[n-1]*arr[n-2];
        return ans*100000;
    }
}