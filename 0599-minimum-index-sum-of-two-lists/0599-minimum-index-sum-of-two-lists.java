class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int n=list1.length;
        int m=list2.length;
        Map<String,Integer> map=new HashMap<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){ 
                if(list1[i].equals(list2[j])) {
                    map.put(list1[i], i+j);
                }
            }
        }
        int minSum=Integer.MAX_VALUE;
        for (int sum:map.values()) {
            if (sum<minSum) minSum=sum;
        }
        List<String> ans=new ArrayList<>();
        for (Map.Entry<String,Integer> entry:map.entrySet()){
            if (entry.getValue()==minSum) {
                ans.add(entry.getKey());
            }
        }
        return ans.toArray(new String[0]);
    }
}
