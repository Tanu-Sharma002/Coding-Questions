class Solution {
    public long getDescentPeriods(int[] prices) {
        int i=0; 
        int j=0;
        long ans=0;
        while(j<prices.length){
            if(j-1>=0){
                if(prices[j-1]!=prices[j]+1) i=j;
                   
            }
            ans +=j-i+1;
            j++;
        }
        return ans;
    }
}