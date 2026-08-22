class Solution {
    public boolean checkDivisibility(int n) {
        int a=n;
        int digitSum=0;
        int digitProduct=1;
        while(a>0){
            int r=a%10;
            digitSum += r;
            digitProduct *= r;
            a /= 10;
        }
        int divisor = digitSum+digitProduct;
        if (divisor==0) return false;
        return n % divisor == 0;
    }
}