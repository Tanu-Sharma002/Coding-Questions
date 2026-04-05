class Solution {
    public int mirrorFrequency(String s) {
        Map<Character,Integer> Freq=new HashMap<>();
        for(char ch : s.toCharArray()){
            Freq.put(ch,Freq.getOrDefault(ch,0)+1);
        }
        int total=0;
        Set<String> pairs=new HashSet<>();
        for(char ch : Freq.keySet()){
            char m=getMirrorCharacter(ch);
            char first = (ch<m)? ch:m;
            char second = (ch<m)? m:ch;
            String pairKey=first+""+second;
            if(!pairs.contains(pairKey)){
                pairs.add(pairKey);
                int freqC = Freq.get(ch);
                int freqM = Freq.getOrDefault(m,0);
                total += Math.abs(freqC-freqM);
            }
        }
        return total;
    }
    private char getMirrorCharacter(char c){
        if(c>='a' && c<='z'){
            return (char)('a'+'z'-c);
        } else if(c>='0' && c<='9'){
            return (char)('0'+'9'-c);
        }
        return c;
    }
}