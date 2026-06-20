class Solution {
    public long finishTime(int n, int[][] edges, int[] baseTime) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int [] edge:edges){
            int parent=edge[0];
            int child=edge[1];
            adj.get(parent).add(child);
        }
        return dfs(0,adj,baseTime);
    }
    private long dfs(int u,List<List<Integer>> adj, int[] baseTime){
        List<Integer> children = adj.get(u);
        if(children.isEmpty()){
            return baseTime[u];
        }
        long earliest=Long.MAX_VALUE;
        long latest=Long.MIN_VALUE;
        for(int child:children){
            long time=dfs(child,adj,baseTime);
            earliest=Math.min(earliest,time);
            latest=Math.max(latest,time);
        }
        long dur=(latest-earliest)+baseTime[u];
        return latest+dur;
    }
}