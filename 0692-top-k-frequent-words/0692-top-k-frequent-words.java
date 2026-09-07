class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String w : words) {
            map.put(w,map.getOrDefault(w,0)+1);
        }
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) -> {
            if(map.get(a).equals(map.get(b))) {
                return a.compareTo(b);
            }
            return map.get(b) - map.get(a);
        });
        return list.subList(0, k);
    }
}