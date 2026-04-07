class Solution {
    int dp[][];
    public int minDistance(String word1, String word2) {
        int n1=word1.length();
        int n2=word2.length();
        dp=new int[n1+1][n2+1];
        for(int[] d:dp) Arrays.fill(d,-1);
        return solve(0,0,word1,word2);
    }
    int solve(int i, int j, String w1, String w2){
        int n1=w1.length();
        int n2=w2.length();
        if(i==n1) return n2-j;
        if(j==n2) return n1-i;
        if(dp[i][j]!=-1) return dp[i][j];
        if(w1.charAt(i)==w2.charAt(j)) return solve(i+1,j+1,w1,w2);
        int insert=1+solve(i,j+1,w1,w2);
        int delete=1+solve(i+1,j,w1,w2);
        int replace=1+solve(i+1,j+1,w1,w2);
        return dp[i][j]=Math.min(insert,Math.min(delete,replace)); 
    }
}