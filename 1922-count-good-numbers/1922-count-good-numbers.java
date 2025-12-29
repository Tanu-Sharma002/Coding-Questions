class Solution {
    static final long mod=1000000007;
    public int countGoodNumbers(long n) {
        long even=(n+1)/2;
        long odd=n/2;
        long ans=(power(5,even)*power(4,odd))%mod;
        return (int) ans;
    }
    long power(long a, long b){
        long res=1;
        while(b>0){
            if((b & 1)==1){
                res = (res*a)%mod;
            }
            a=(a*a)%mod;
            b>>=1;
        }
        return res;
    }
}