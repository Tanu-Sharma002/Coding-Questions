class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int r=image.length;
        int c=image[0].length;
        int[][] ans = new int[r][c];
        int x=0;
        int y=0;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                ans[i][j] = image[i][c - 1 - j];
            }
        }
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(ans[i][j]==0) ans[i][j]=1;
                else ans[i][j]=0;
            }
        }
        return ans;
    }
}