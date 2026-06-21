class Solution {
    public String firstPalindrome(String[] words) {
        for(int i=0; i<words.length; i++){
            String w=words[i];
            if(isPalindrome(w)) return w;
        }
        return "";
    }
    private static boolean isPalindrome(String w){
        int l=0; 
        int r=w.length();
        while(l<r){
            if(w.charAt(l)!=w.charAt(r-1)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}