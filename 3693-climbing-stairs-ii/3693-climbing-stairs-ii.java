class Solution {
    public int climbStairs(int n, int[] costs) {
        int v0=1;
        int v1=0;
        int v2=0;
        int v=0;
        for(int cost:costs){
            v=Math.min(Math.min(v0+9,v1+4),(v2+1))+cost;
            v0=v1;
            v1=v2;
            v2=v;
        }
        return v2;
    }
}