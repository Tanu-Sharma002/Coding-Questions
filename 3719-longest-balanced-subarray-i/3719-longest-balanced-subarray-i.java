class Solution {
    public int longestBalanced(int[] arr) {
        int n = arr.length;
        int ans = 0;
        for(int i=0;i<n;i++){
            HashSet<Integer> e = new HashSet<Integer>();
            HashSet<Integer> o = new HashSet<Integer>();
            for(int j=i;j<n;j++){
                if((arr[j]&1)==0) e.add(arr[j]);
                else o.add(arr[j]);
                if(e.size()==o.size()){
                    ans = Math.max(ans,j-i+1);
                }
            }
        }
        return ans;
    }
}