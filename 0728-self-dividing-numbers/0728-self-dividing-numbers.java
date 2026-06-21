class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res=new ArrayList<>();
        for(int i=left; i<=right; i++){
            if(selfDivide(i)) res.add(i);
        }
        return res;
    }
    private static boolean selfDivide(int i){
        int num=i;
        while(num>0){
            int r=num%10;
            if(r==0) return false;
            else {
                if(i%r != 0) return false;
            }
            num=num/10;
        }
        return true;
    }
}