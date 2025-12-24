class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum=0;
        int count=0;
        for(int i=0; i<apple.length; i++){
            sum += apple[i];
        }
        if(sum==0) return 0;
        Arrays.sort(capacity);
        if(sum<=capacity[capacity.length-1]) return 1;
        for(int i=capacity.length-1; i>=0; i--){
            sum = sum-capacity[i];
            count++;
            if(sum<=0) return count;
        }
        return count;
    }
}