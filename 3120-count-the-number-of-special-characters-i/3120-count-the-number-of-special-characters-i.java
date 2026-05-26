class Solution {
    public int numberOfSpecialChars(String word) {
        Set<Character> set1=new HashSet<>();
        Set<Character> set2=new HashSet<>();
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(Character.isLowerCase(ch)) set1.add(ch);
            else set2.add(Character.toLowerCase(ch));
        }
        int count=0;
        for(Character i:set1){
            if(set2.contains(i)) count++;
        }
        return count;
    }
}