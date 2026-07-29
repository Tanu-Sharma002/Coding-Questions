class Pair{
    String first;
    int second;
    Pair(String first, int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord,1));
        Set<String> set = new HashSet<>();
        int len = wordList.size();
        for(String s:wordList){
            set.add(s);
        }
        set.remove(beginWord);
        while(! queue.isEmpty()){
            String word=queue.peek().first;
            int steps=queue.peek().second;
            queue.remove();
            if(word.equals(endWord)) return steps;
            for(int i=0; i<word.length(); i++){
                for(char ch='a'; ch<='z'; ch++){
                    char[] replacedArr=word.toCharArray();
                    replacedArr[i]=ch;
                    String replacedWord=new String(replacedArr);
                    if(set.contains(replacedWord)){
                        set.remove(replacedWord);
                        queue.add(new Pair(replacedWord,steps+1));
                    }
                }
            }
        }
        return 0;
    }
}