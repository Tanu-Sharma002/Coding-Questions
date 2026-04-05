class Solution {
    public List<Integer> findGoodIntegers(int n) {
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<long[]> pq = new PriorityQueue<>((x,y)->Long.compare(x[0],y[0]));
        for(long i=1; i*i*i*2<=n; i++){
            pq.add(new long[]{i*i*i+i*i*i,i,i});
        }
        if(pq.isEmpty()) return ans;
        long lastSum = -1;
        int count =0;
        while(!pq.isEmpty()){
            long[] curr=pq.poll();
            long sum=curr[0];
            long a=curr[1];
            long b=curr[2];
            if(sum==lastSum) count++;
            else {
                if(count>=2){
                    ans.add((int) lastSum);
                }
                lastSum=sum;
                count=1;
            }
            long nextB = b+1;
            long nextSum=a*a*a+nextB*nextB*nextB;
            if(nextSum <= n){
                pq.add(new long[]{nextSum,a,nextB});
            }
        }
        if(count>=2){
            ans.add((int) lastSum);
        }
        return ans;
    }
}