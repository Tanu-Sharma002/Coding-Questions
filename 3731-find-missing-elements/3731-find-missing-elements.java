class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums); 
        List<Integer> list= new ArrayList<>();
        int n=nums.length-1;
        int a=nums[0];
        int b=nums[n];
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<=n; i++){
            set.add(nums[i]);
        }
        for(int i=a; i<=b; i++){
            if(!set.contains(i)) list.add(i);
        }
        return list;
    }
}