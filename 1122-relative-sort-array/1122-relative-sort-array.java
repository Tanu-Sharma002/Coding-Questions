class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int max=0;
        int n=arr1.length;
        for(int i=0; i<n; i++){
            max=Math.max(max,arr1[i]);
        }
        int[] count =new int[max+1];
        for(int i=0; i<n; i++){
            count[arr1[i]]++ ;
        }
        int[] ans =new int[n];
        int idx=0;
        for(int i=0; i<arr2.length; i++){
            while(count[arr2[i]]>0) {
                ans[idx] = arr2[i];
                count[arr2[i]]-- ;
                idx++;
            }
        }
        for(int i=0;i<count.length;i++){
            while(count[i]>0){
                ans[idx]=i;
                count[i]--;
                idx++;
            }
        }
        return ans;
    }
}