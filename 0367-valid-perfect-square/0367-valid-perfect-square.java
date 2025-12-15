class Solution {
    public boolean isPerfectSquare(int num) {
        long start=0;
        long sqr=0;
        long end=num;
        while(start<=end){
            long mid = start+(end-start)/2;
            sqr=mid*mid;
            if(num==sqr)
                return true;
            else if(num>sqr)
                start=mid+1;
            else
                end=mid-1;
        }
        return false;
    }
}