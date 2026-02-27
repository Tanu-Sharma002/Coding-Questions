class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n=moveTime.length;
        int m=moveTime[0].length;
        int time[][] = new int[n][m];
        for(int[] t : time){
            Arrays.fill(t, Integer.MAX_VALUE);
        }
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        pq.offer(new int[] {0,0,0});
        time[0][0]=0;
        int directions[][] = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!pq.isEmpty()){
            int curr[] = pq.poll();
            int curr_time = curr[0];
            int r=curr[1];
            int c=curr[2];
            if(r==n-1 && c==m-1) return curr_time;
            for(int[] d:directions){
                int nr = r+d[0];
                int nc = c+d[1];
                if(nr>=0 && nc>=0 && nr<n && nc<m){
                    int newTime=Math.max(curr_time+1, moveTime[nr][nc]+1);
                    if(newTime< time[nr][nc]){
                        time[nr][nc]=newTime;
                        pq.offer(new int[] {newTime,nr,nc});
                    }
                }
            }
        }
        return 0;
    }
}