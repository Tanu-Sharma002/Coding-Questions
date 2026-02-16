class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int fresh=0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==2){
                    queue.offer(new int[]{i,j});
                }
                if(grid[i][j]==1) fresh++;
            }
        }
        if(fresh==0) return 0;
        int time=0;
        int directions[][] = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!queue.isEmpty()){
            int size=queue.size();
            boolean rotted=false;
            for(int i=0; i<size; i++){
                int[] cell=queue.poll();
                int r=cell[0];
                int c=cell[1];
                for(int[] dir:directions){
                    int nr = r+dir[0];
                    int nc = c+dir[1];
                    if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc]==1){
                        grid[nr][nc]=2;
                        queue.offer(new int[]{nr,nc});
                        fresh--;
                        rotted=true;
                    }
                }
            }
            if (rotted) time++;
        }
        return fresh==0 ? time:-1;
    }
}