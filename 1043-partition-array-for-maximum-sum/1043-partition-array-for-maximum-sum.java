class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        Integer res[] = new Integer[arr.length+1];
        return helper(arr,res,k,0);
    }
    

    int helper(int arr[], Integer res[], int k, int i){
        if(res[i] != null) return res[i];
        if(i>=arr.length) return 0;
        int ans=Integer.MIN_VALUE;
        int max=Integer.MIN_VALUE;
        for(int j=i; j<arr.length && j<i+k; j++){
            int len=j-i+1;
            max=Math.max(max,arr[j]);
            ans=Math.max(ans,len*max+helper(arr,res,k,j+1));
        }
        return res[i]=ans;
    }
}