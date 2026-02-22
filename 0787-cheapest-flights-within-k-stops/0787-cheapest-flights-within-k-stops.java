class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<int []> graph[] = new ArrayList[n];
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] f: flights){
            int u=f[0], v=f[1], cost=f[2];
            graph[u].add(new int[] {v,cost});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        pq.offer(new int[] {0,src,0});
        int [][] best = new int[n][k+2];
        for(int[] b: best) Arrays.fill(b,Integer.MAX_VALUE);
        best[src][0]=0;
        while(!pq.isEmpty()){
            int arr[] = pq.poll();
            int costSoFar=arr[0];
            int city = arr[1];
            int stops = arr[2];
            if(city==dst) return costSoFar;
            if(stops>k) continue;
            for(int[] next:graph[city]){
                int nextCity = next[0];
                int nextCost = next[1];
                int newCost = costSoFar+nextCost;
                if(newCost<best[nextCity][stops+1]){
                    best[nextCity][stops+1] = newCost;
                    pq.offer(new int[]{newCost,nextCity,stops+1});
                }
            }
        }
        return -1;
    }
} 
