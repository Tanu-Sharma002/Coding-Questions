class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans= new ArrayList<>();
        int num=1;
        for(int i=0; i<target.length; i++){
            while(num<target[i]){
                ans.add("Push");
                ans.add("Pop");
                num++;
            }
            ans.add("Push");
            num++;
        }
        return ans;
    }
}