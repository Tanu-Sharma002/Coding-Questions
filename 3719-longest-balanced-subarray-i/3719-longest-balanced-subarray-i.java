class Solution {
    public int longestBalanced(int[] nums) {
        int maxlen=0;
        for(int i=0; i<nums.length; i++){
            HashSet<Integer> evenSet = new HashSet<>();
            HashSet<Integer> oddSet = new HashSet<>();
            for(int j=i;j<nums.length;j++){
                if(nums[j]%2==1){
                    oddSet.add(nums[j]);
                }else{
                    evenSet.add(nums[j]);
                }
                if(evenSet.size()==oddSet.size()) {
                    int len=(j-i+1);
                    maxlen=Math.max(maxlen,len);
                }
            }  
        }
        return maxlen;  
    }
}