class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String,Integer> map = new LinkedHashMap<>();
        for(String a:arr){
            if(!map.containsKey(a)){
                map.put(a,1);
            } else {
                map.put(a,map.get(a)+1);
            }
        }
        int count=0;
        for(String s:map.keySet()){
            if(map.get(s)==1) count++;
            if(count==k) return s;
        }
        return "";
    }
}