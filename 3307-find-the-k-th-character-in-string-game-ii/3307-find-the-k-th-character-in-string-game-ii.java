class Solution {
    public char kthCharacter(long k, int[] operations) {
        int n=operations.length;
        long[] len = new long[n+1];
        len[0]=1;
        for (int i=0; i<n; i++) {
            len[i+1]=Math.min(k,len[i]*2);
        }
        int shift=0;
        k--;
        for (int i=n-1; i>=0; i--) {
            long half=len[i];
            if (k >= half){
                k -= half;
                if(operations[i] == 1) shift++;
            }
        }
        return (char)('a'+(shift%26));
    }
}