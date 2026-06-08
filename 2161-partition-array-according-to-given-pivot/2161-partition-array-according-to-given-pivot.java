class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> l1=new ArrayList<>();
        List<Integer> l2=new ArrayList<>();
        int cnt=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]<pivot) l1.add(nums[i]);
            else if(nums[i]>pivot) l2.add(nums[i]);
            else cnt++;
        }
        int i=0;
        for(int num:l1){
            nums[i]=num;
            i++;
        }
        while(cnt-->0){
            nums[i]=pivot;
            i++;
        }
        for(int num:l2){
            nums[i]=num;
            i++;
        }
        return nums;
    }
}