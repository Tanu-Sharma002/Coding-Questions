class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int count =0;
        int n=happiness.length-1;
        long sum=0;
        for(int i=n; i>=0 && count<k; i--){
            int value = happiness[i] - count;
            if(value <= 0){
                break;
            }
            sum += value;
            count++;
        }
        return sum;
    }
}