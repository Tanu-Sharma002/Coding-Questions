class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset= new ArrayList<>();
        generateSubsets(1,n,subset,ans,k);
        return ans;
    }
    void generateSubsets(int index,int n,List<Integer> subset, List<List<Integer>> ans,int k){
        if(subset.size()==k){
            ans.add(new ArrayList(subset));
            return;
        }
        for(int i=index; i<=n; i++){
            subset.add(i);
            generateSubsets(i+1,n,subset,ans,k);
            subset.remove(subset.size()-1);
        }
    } 
}