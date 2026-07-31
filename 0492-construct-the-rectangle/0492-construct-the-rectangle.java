class Solution {
    public int[] constructRectangle(int area) {
        int w=(int)Math.sqrt(area);
        int ans[]=new int[2];
        for(int i=w; i>=1; i--){
            if(area%i==0){
                ans[1]=i;
                ans[0]=area/i;
                break;
            }
        }
        return ans;
    }
}