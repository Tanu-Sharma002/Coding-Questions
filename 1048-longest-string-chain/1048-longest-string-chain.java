class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b)->a.length()-b.length());
        int dp[]= new int[words.length];
        Arrays.fill(dp,1);
        int maxi=1;
        for(int i=0; i<words.length; i++){
            for(int j=0; j<i; j++){
                if(isValid(words[i],words[j]) && 1+dp[j]>dp[i]){
                    dp[i]=1+dp[j];
                }
            }
            maxi=Math.max(maxi,dp[i]);
        }
        return maxi;
    }
    private static boolean isValid(String s1, String s2){
        if(s1.length() != s2.length()+1) return false;
        int first=0, second=0;
        while(first<s1.length() && second<s2.length()){
            if(s1.charAt(first)==s2.charAt(second)){
                first++;
                second++;
            } else {
                first++;
            }
        }
        return second==s2.length();
    }
}