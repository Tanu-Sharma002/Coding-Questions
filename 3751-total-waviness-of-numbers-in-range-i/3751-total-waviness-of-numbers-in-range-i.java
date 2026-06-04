class Solution {
    public int totalWaviness(int num1, int num2) {
        int ans=0;
        for(int i=num1; i<=num2; i++){
            ans += helper(i);
        }
        return ans;
    }
    private static int helper(int x){
        int count=0;
        String s=Integer.toString(x);
        for(int j=1; j<s.length()-1; j++){
            if(s.charAt(j)>s.charAt(j-1) && s.charAt(j)>s.charAt(j+1) || s.charAt(j)<s.charAt(j-1) && s.charAt(j)<s.charAt(j+1)) {
                count++;
            }
        }
        return count;
    }
}