class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a,b)->{
            return (map.get(a) == map.get(b))? b - a : map.get(a) - map.get(b);
        });
            
        int[] res = new int[nums.length];
        int i=0;
        for (int num:list) {
            for (int j=0; j<map.get(num); j++) {
                res[i++] = num;
            }
        }
        return res;
    }
}