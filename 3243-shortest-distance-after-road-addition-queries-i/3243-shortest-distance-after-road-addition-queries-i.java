class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i=0; i<n-1; i++) {
            adj.get(i).add(i + 1);
        }
        int q = queries.length;
        int[] res = new int[q];
        int idx = 0;
        for (int[] curr : queries) {
            int u = curr[0];
            int v = curr[1];
            adj.get(u).add(v);
            int d = bfs(n, adj);
            res[idx++] = d;
        }
        return res;
    }
    public static int bfs(int n, List<List<Integer>> adj) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        boolean[] visited = new boolean[n];
        visited[0] = true;
        int level = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                int node=queue.poll();
                if (node==n-1)
                    return level;
                for (int ngh:adj.get(node)) {
                    if(!visited[ngh]) {
                        queue.offer(ngh);
                        visited[ngh] = true;
                    }
                }
            }
            level++;
        }
        return -1;
    }
}