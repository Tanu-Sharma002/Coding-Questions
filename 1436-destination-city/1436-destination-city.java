class Solution {
    public String destCity(List<List<String>> paths) {
        HashSet<String> set = new HashSet<>();
        for(List<String> path : paths){
            set.add(path.get(0));
        }
        for(List<String> path : paths){
            String str=path.get(1);
            if(!set.contains(str)) {
                return str;
            }
        }
        return "";
    }
}