class Solution {
    public int numIslands(char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int count=0;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(grid[i][j]=='1'){
                    count++;
                    q.offer(new int[]{i,j});
                    grid[i][j]='0';
                    while(!q.isEmpty()){
                        int curr[] = q.poll();
                        int[] row = {-1, 1, 0, 0};
                        int[] col = {0, 0, -1, 1};
                        for(int k=0; k<4; k++){
                            int ni=curr[0]+row[k];
                            int nj=curr[1]+col[k];
                            if(ni>=0 && nj>=0 && ni<r && nj<c && grid[ni][nj]=='1'){
                                grid[ni][nj]='0';
                                q.offer(new int[]{ni, nj}); 
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}