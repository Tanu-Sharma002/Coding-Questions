class Solution {
    public int countGoodSubstrings(String s) {
        int count=0;
        for(int  i=1; i<s.length()-1; i++){
            char a = s.charAt(i-1);
            char b = s.charAt(i);
            char c = s.charAt(i+1);
            if(a != b && b != c && a != c){
                count++;
            }
        }
        return count;
    }
}