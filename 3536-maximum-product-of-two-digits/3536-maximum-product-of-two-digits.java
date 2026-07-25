class Solution {
    public int maxProduct(int n) {
        int digits[] = new int[10];
        Arrays.fill(digits,-1);
        int i=0;
        while(n>0){
            int r=n%10;
            n=n/10;
            digits[i]=r;
            i++;
        }
        Arrays.sort(digits);
        return (digits[9]*digits[8]);
    }
}