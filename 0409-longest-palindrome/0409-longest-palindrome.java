class Solution {
    public int longestPalindrome(String s) {
        Map<Character,Integer> map=new HashMap<>();
        int count=0;
        for(int i=0; i<s.length(); i++){
            if(map.containsKey(s.charAt(i))) map.put(s.charAt(i),map.get(s.charAt(i))+1);
            else map.put(s.charAt(i),1);
        }
        boolean hasOdd = false;
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            if(entry.getValue()%2==0) count=count+entry.getValue();
            else{ 
                count +=  entry.getValue()-1;
                hasOdd = true;
            }
        }
        if(hasOdd)count++;
        return count;
    }
}