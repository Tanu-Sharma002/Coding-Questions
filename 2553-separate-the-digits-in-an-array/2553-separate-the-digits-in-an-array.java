class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            int n=nums[i];
            List<Integer> temp = new ArrayList<>();
            if(nums[i]<=9) list.add(nums[i]);
            else{
                while(n>0){
                    int r=n%10;
                    list.add(r);
                    n=n/10;
                }
                for(int j=temp.size()-1; j>=0; j--) {
                list.add(temp.get(j));
                }
            }
        }
        int ans[] = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            ans[i]=list.get(i);
        }
        return ans;
    }
}