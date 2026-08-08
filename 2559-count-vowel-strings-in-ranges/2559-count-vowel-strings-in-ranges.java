class Solution {
    public int[] vowelStrings(String[] words, int[][] queries){
        int[] sum=new int[words.length+1];
        for (int i=0; i<words.length; i++){
            sum[i+1] = sum[i]+(isVowelString(words[i])? 1:0);
        }
        int[] ans=new int[queries.length];
        for (int i=0; i<queries.length; i++){
            ans[i]=sum[queries[i][1]+1]-sum[queries[i][0]];
        }
        return ans;
    }
    private boolean isVowelString(String w){
        return isVowel(w.charAt(0))&& isVowel(w.charAt(w.length()-1));
    }
    private boolean isVowel(char c){
        return c=='a' || c=='e' || c=='i' || c=='o' || c=='u';
    }
}
