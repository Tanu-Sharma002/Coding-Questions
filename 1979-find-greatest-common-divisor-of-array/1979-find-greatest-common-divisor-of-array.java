class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int a = nums[0];
        int b = nums[nums.length-1];
        return gcd(a,b);
    }
    static int gcd(int a, int b){
        if(a==0 || b==0) return Math.max(a, b);
        int result = Math.min(a, b);
        while (result > 0) {
            if (a%result==0 && b%result==0) break;
            result--;
        }
        return result;
    }
}