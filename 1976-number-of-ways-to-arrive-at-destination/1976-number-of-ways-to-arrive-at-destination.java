class Solution {
    static class Pair{
        int node;
        long dist;
        Pair(int node, long dist){
            this.node=node;
            this.dist=dist;
        }
    }

    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < roads.length; i++) {
            int u = roads[i][0];
            int v = roads[i][1];
            int w = roads[i][2];
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }
        PriorityQueue<Pair> p = new PriorityQueue<Pair>((a,b)-> Long.compare(a.dist, b.dist));
        long dist[] = new long[n];
        long ways[] = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;
        p.add(new Pair(0,0));
        int mod = 1000000007;
        while(!p.isEmpty()){
            Pair curr = p.poll();
            long currDist = curr.dist;
            int node = curr.node;
            if(currDist > dist[node]) continue;
            for(Pair neighbour : adj.get(node)){
                int adjNode = neighbour.node;
                long Weight = neighbour.dist;
                if(currDist+Weight < dist[adjNode]){
                    dist[adjNode] = currDist+Weight ;
                    p.offer(new Pair(adjNode, dist[adjNode]));
                    ways[adjNode] = ways[node];
                }else if(currDist+Weight == dist[adjNode]){
                    ways[adjNode] = (ways[adjNode]+ways[node])%mod;
                }
            }
        }
        return (int)(ways[n-1]%mod);
    }
}