class Solution {
    public int[] singleNumber(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            if(set.contains(nums[i])) set.remove(nums[i]);
            else set.add(nums[i]);
        }
        int j=0;
        int ans[]=new int[2];
        for(int i:set){
            ans[j]=i;
            j++;
        }
        return ans;
    }
}