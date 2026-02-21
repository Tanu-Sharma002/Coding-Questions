class Solution {
    public int numEnclaves(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<r; i++){
            if(grid[i][0]==1){
                q.offer(new int[]{i,0});
                grid[i][0]=0;
            }
            if(grid[i][c-1]==1){
                q.offer(new int[]{i,c-1});
                grid[i][c-1]=0;
            }
        }
        for(int j=0; j<c; j++){
            if(grid[0][j]==1){
                q.offer(new int[]{0,j});
                grid[0][j]=0;
            }
            if(grid[r-1][j]==1){
                q.offer(new int[]{r-1,j});
                grid[r-1][j]=0;
            }
        }
        int row[] = {-1,1,0,0};
        int col[] = {0,0,-1,1};
        while(!q.isEmpty()){
            int curr[] =q.poll();
            for(int k=0; k<4; k++){
                int ni = curr[0]+row[k];
                int nj = curr[1]+col[k];
                if(ni>=0 && nj>=0 && ni<r && nj<c && grid[ni][nj]==1){
                    grid[ni][nj]=0;
                    q.offer(new int[]{ni,nj});
                }
            }
        }
        int count =0;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(grid[i][j]==1){
                    count++;
                }
            }
        }
        return count;
    }
}