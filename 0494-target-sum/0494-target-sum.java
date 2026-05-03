

class Solution {
    Map<String,Integer> hm;
    public int findTargetSumWays(int[] nums, int target) {
        hm=new HashMap<>();
        return findTargetSumWays(nums,target,0,nums.length-1);
    }
    public int findTargetSumWays(int[] nums,int target,int cs,int index){
        String key=index+"@"+cs;
        if(hm.containsKey(key)){
            return hm.get(key);
        }
        if(index<0 && cs==target){
            return 1;
        }
        if(index<0){
            return 0;
        }
        int pos=findTargetSumWays(nums,target,cs+nums[index],index-1);
        int neg=findTargetSumWays(nums,target,cs-nums[index],index-1);
        hm.put(key,pos+neg);
        return pos+neg;
    }
}