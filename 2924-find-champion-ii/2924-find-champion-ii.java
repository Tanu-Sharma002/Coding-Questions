class Solution {
    public int findChampion(int n, int[][] edges) {
        int indegree[] = new int[n];
        for(int e[]:edges){
            int v=e[1];
            indegree[v]++;
        }
        int champ=-1;
        int count=0;
        for(int i=0; i<n; i++){
            if(indegree[i]==0){
                champ=i;
                count++;
            }
        }
        if(count==1) return champ;
        return -1;
    }
}