class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        int parent[] = new int[n];
        for(int i=0; i<n; i++){
            parent[i]=i;
        }
        Arrays.sort(edgeList,(a,b)->a[2]-b[2]);
        int l = edgeList.length;
        int m = queries.length;
        int[][] q=new int[m][4];
        for(int i=0; i<m; i++){
            q[i][0]=queries[i][0];
            q[i][1]=queries[i][1];
            q[i][2]=queries[i][2];
            q[i][3]=i;
        }
        Arrays.sort(q,(a,b)->a[2]-b[2]);
        boolean[] ans = new boolean[m];
        int idx=0;
        for(int[] query:q){
            int p=query[0];
            int r=query[1];
            int limit=query[2];
            int index=query[3];
            while(idx<l && edgeList[idx][2]<limit){
                union(edgeList[idx][0],edgeList[idx][1],parent);
                idx++;
            }
            if(find(p,parent)==find(r,parent)){
                ans[index]=true;
            }
        }
        return ans;
    }
    private void union(int a, int b, int parent[]){
        int pa=find(a,parent);
        int pb=find(b,parent);
        if(pa != pb) parent[pa]=pb;
    }
    private int find(int x, int[] parent){
        if(parent[x] != x){
            parent[x]=find(parent[x],parent);
        }
        return parent[x];
    }
}