class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Map<Integer, List<String>> backtrack = new HashMap<>();
        return helper(s, 0, set, backtrack);
    }
    private List<String> helper(String s, int start, Set<String> set, Map<Integer, List<String>> backtrack){
        if(backtrack.containsKey(start)) return backtrack.get(start);
        List<String> result = new ArrayList<>();
        if(start==s.length()){
            result.add("");
            return result;
        }
        for(int i=start+1; i<=s.length(); i++){
            String word=s.substring(start,i);
            if(set.contains(word)){
                List<String> next=helper(s,i,set,backtrack);
                for(String sub:next){
                    if(sub.isEmpty()) result.add(word);
                    else result.add(word + " " + sub);
                }
            }
        }
        // backtrack.put(start,result);
        return result;
    }
}