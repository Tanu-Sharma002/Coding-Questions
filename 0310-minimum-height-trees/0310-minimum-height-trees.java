class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans=new ArrayList<>();
        if(n==1){
            ans.add(0);
            return ans;
        }
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        int degree[] = new int[n+1];
        for(int edge[]:edges){
            int u=edge[0];
            int v=edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
            degree[u]++;
            degree[v]++;
        }
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0; i<n; i++){
            if(degree[i]==1) queue.offer(i);
        }
        int remainNodes=n;
        while(remainNodes>2){
            int size=queue.size();
            remainNodes-=size;
            for(int i=0; i<size; i++){
                int node=queue.poll();
                for(int nei:graph.get(node)){
                    degree[nei]--;
                    if(degree[nei]==1){
                        queue.offer(nei);
                    }
                }
            }
        }
        while(!queue.isEmpty()){
            ans.add(queue.poll());
        }
        return ans;
    }
}