class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int sum=0;
        int count=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            int remove = sum-goal;
            if(map.containsKey(remove)){
                count += map.get(remove);
            }
            if(map.containsKey(sum)){
                map.put(sum,map.get(sum)+1);
            } else {
                map.put(sum,1);
            }
        }
        return count;
    }
}