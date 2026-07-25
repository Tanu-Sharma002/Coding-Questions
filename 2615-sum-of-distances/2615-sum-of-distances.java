class Solution {
    public long[] distance(int[] arr) {
        int n=arr.length;
        long ans[] = new long[arr.length];
        HashMap<Integer, ArrayList<Integer>> map=new HashMap<>();
        for(int i=0; i<arr.length; i++){
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], new ArrayList<>());
            }
            map.get(arr[i]).add(i);
        }
        for(ArrayList<Integer> list:map.values()){
            int m=list.size();
            if(m==1)continue;
            long[] prefix = new long[m];
            prefix[0]=list.get(0);
            for(int i=1; i<m; i++){
                prefix[i]=prefix[i-1]+list.get(i);
            }
            long total=prefix[m-1];
            for(int i=0; i<m; i++){
                long current=list.get(i);
                long leftSum=(i==0)? 0:prefix[i-1];
                long rightSum = total - prefix[i];
                long left = current * i - leftSum;
                long right=rightSum-current*(m-i-1);
                ans[list.get(i)]=left+right;
            }
        }
        return ans;
    }
}