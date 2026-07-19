class Solution {
    static class Pair{
        int node;
        int dist;
        Pair(int node, int dist){
            this.node=node;
            this.dist=dist;
        }
    }
    public int minScore(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }
        for(int road[]:roads){
            int u=road[0];
            int v=road[1];
            int d=road[2];
            adj.get(u).add(new Pair(v,d));
            adj.get(v).add(new Pair(u,d));
        }
        boolean vis[]=new boolean[n+1];
        int result[]={Integer.MAX_VALUE};
        dfs(1,adj,vis,result);
        return result[0];
    }
    private static void dfs(int node, ArrayList<ArrayList<Pair>> adj, boolean vis[], int result[]){
        vis[node]=true;
        for(Pair p:adj.get(node)){
            result[0]=Math.min(result[0], p.dist);
            if(!vis[p.node]){
                dfs(p.node, adj, vis, result);
            }
        }
    }
}