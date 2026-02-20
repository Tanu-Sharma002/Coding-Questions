class Pair {
    int dest;
    int cost;
    Pair(int dest, int cost) {
        this.dest = dest;
        this.cost = cost;
    }
}
class Graph {
    ArrayList<ArrayList<Pair>> adj;
    int n;
    public Graph(int n, int[][] edges) {
        this.n = n; 
        adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++) {
            int src = edges[i][0];
            int dest = edges[i][1];
            int cost = edges[i][2];
            adj.get(src).add(new Pair(dest, cost));
        }
    }
    public void addEdge(int[] edge) {
        int src = edge[0];
        int dest = edge[1];
        int cost = edge[2];
        adj.get(src).add(new Pair(dest, cost));
    }
    public int shortestPath(int node1, int node2) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[node1] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[1], b[1]);
            }
        });
        pq.offer(new int[]{node1, 0});
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int cost = curr[1];
            if(cost > dist[node]) continue;
            if(node == node2) return cost;
            for(Pair neighbour : adj.get(node)) { 
                int nextNode = neighbour.dest;
                int weight = neighbour.cost;
                if(dist[nextNode] > cost + weight) {
                    dist[nextNode] = cost + weight;
                    pq.offer(new int[]{nextNode, dist[nextNode]});
                }
            }
        }
        return -1;
    }
}