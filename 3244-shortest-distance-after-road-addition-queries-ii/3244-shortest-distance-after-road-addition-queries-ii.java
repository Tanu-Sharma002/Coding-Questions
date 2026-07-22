class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int q = queries.length;
        int[] res = new int[q];
        int[] next = new int[n];
        for(int i=0; i<n; i++){
            next[i]=i+1;
        }
        next[n-1]=-1;
        int d=n-1;
        for (int i=0; i<q; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            if(next[u]!=-1 && next[u]<v){
                int curr=next[u];
                while(curr<v){
                    d--;
                    int temp=next[curr];
                    next[curr]=-1;
                    curr=temp;
                }
                next[u]=v;
            }
            res[i] = d;
        }
        return res;
    }
}