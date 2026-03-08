class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int ans[] = new int[2];
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(set.contains(grid[i][j])){
                    ans[0]=grid[i][j];
                }else{
                    set.add(grid[i][j]);
                }
            }
        }
        int n=grid.length;
        for(int k=1; k<=n*n; k++){
            if(!set.contains(k)){
                ans[1]=k;
                break;
            }
        }
        return ans;
    }
}