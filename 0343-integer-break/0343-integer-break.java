class Solution {
    public int integerBreak(int n) {
        if(n==2) return 1;
        if(n==3) return 2;
        int cnt=1;
        int r=n%3;
        int prod=1;
        while(n>4){
            prod = prod*3;
            n=n-3;
        }
        return prod*n;
    }
}