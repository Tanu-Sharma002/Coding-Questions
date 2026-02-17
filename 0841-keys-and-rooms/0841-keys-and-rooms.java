class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean [] visited = new boolean[rooms.size()];
        dfs(0, rooms, visited);
        for(boolean v: visited){
            if(!v) return false;
        }
        return true;
    }
    private void dfs(int r, List<List<Integer>> rooms, boolean[] visited){
        if(visited[r]) return ;
        visited[r] = true;
        for(int key: rooms.get(r)){
            dfs(key,rooms, visited);
        }
    }
}
