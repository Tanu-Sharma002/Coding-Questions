class Solution {
    class Pair {
        int node;
        int weight;
        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : times){
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];
            adj.get(u).add(new Pair(v, w));
        }
        int[] dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.offer(new int[] {k,0});
        while(!pq.isEmpty()){
            int curr[] = pq.poll();
            int node = curr[0];
            int time = curr[1];
            if(time>dist[node]) continue;
            for(Pair ngh : adj.get(node)){
                int next=ngh.node;
                int weight=ngh.weight;
                if(dist[next]>time+weight){
                    dist[next]=time+weight;
                    pq.offer(new int[]{next,dist[next]});
                }
            }
        }
        int max=0;
        for(int i=1; i<=n; i++){
            if(dist[i]==Integer.MAX_VALUE) return -1;
            max = Math.max(max, dist[i]);
        }
        return max;
    }
}