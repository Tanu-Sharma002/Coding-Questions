class Solution {
    public int[] sortEvenOdd(int[] nums) {
        List<Integer> oddList = new ArrayList<>();
        List<Integer> evenList = new ArrayList<>();
        int odd=1;
        int even=0;
        while(odd<nums.length){
            oddList.add(nums[odd]);
            odd=odd+2;
        }
        Collections.sort(oddList, Collections.reverseOrder());
        while(even<nums.length){
            evenList.add(nums[even]);
            even=even+2;
        }
        Collections.sort(evenList);
        int j=0;
        int k=0;
        for(int i=0; i<nums.length; i++){
            if(i%2==0){
                nums[i]=evenList.get(j);
                j++;
            } else {
                nums[i]=oddList.get(k);
                k++;
            }
        } 
        return nums;
    }
}