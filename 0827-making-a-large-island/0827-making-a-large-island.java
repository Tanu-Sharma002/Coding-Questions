class Solution {
    int parent[];
    int size[];
    int find(int x){
        if(parent[x]==x) return x;
        return parent[x]=find(parent[x]);
    }
    void union(int a, int b){
        int pa=find(a);
        int pb=find(b);
        if(pa==pb) return;
        if(size[pa]<size[pb]){
            parent[pa]=pb;
            size[pb]+=size[pa];
        } else {
            parent[pb]=pa;
            size[pa]+=size[pb];
        }
    }
    public int largestIsland(int[][] grid) {
        int n=grid.length;
        parent=new int[n*n];
        size=new int[n*n];
        for(int i=0; i<n*n; i++){
            parent[i]=i;
            size[i]=1;
        }
        int dr[] = {-1,1,0,0};
        int dc[] = {0,0,-1,1};
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==0) continue;
                int node=i*n+j;
                for(int k=0; k<4; k++){
                    int nr=i+dr[k];
                    int nc=j+dc[k];
                    if(nr>=0 && nr<n && nc>=0 && nc<n && grid[nr][nc]==1){
                        int adj=nr*n+nc;
                        union(node,adj);
                    }
                }
            }
        }
        int ans=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1) continue;
                HashSet<Integer> set=new HashSet<>();
                for(int k=0; k<4; k++){
                    int nr=i+dr[k];
                    int nc=j+dc[k];
                    if(nr>=0 && nr<n && nc>=0 && nc<n && grid[nr][nc]==1) set.add(find(nr*n+nc));
                }
                int total=1;
                for(int parent:set){
                    total += size[parent];
                }
                ans=Math.max(ans,total);
            }
        }
        for(int i=0; i<n*n; i++){
            if(parent[i]==i) ans=Math.max(ans,size[i]);
        }
        return ans;
    }
}