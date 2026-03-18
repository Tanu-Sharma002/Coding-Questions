class Solution {
    public int findChampion(int[][] grid) {
        int arr[]= new int[grid.length];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1){
                    arr[i]=arr[i]+1;
                }
            }
        }
        int max=arr[0];
        for(int i=1; i<arr.length; i++){
            max=Math.max(max,arr[i]);
        }
        for(int i=0; i<arr.length; i++){
            if(arr[i]==max) return i;
        }
        return -1;
    }
}