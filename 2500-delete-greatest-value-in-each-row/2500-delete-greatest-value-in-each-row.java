class Solution {
    public int deleteGreatestValue(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int ans=0;
        for(int[] arr:grid){
            Arrays.sort(arr);
        }
        for(int i=0; i<n; i++){
            int max=0;
            for(int j=0; j<m; j++){
                max=Math.max(max,grid[j][i]);
            }
            ans+=max;
        }
        return ans;
    }
}