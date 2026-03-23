class Solution {
    public int numberOfWays(String corridor) {
        int mod = 1000000007;
        char[] s = corridor.toCharArray();
        ArrayList<Integer> index = new ArrayList<>();
        
        for(int i = 0; i < s.length; i++){
            if(s[i] == 'S') index.add(i);
        }
        
        if(index.size() % 2 != 0 || index.size() == 0) return 0;
        
        long res = 1;
        int end = index.get(1);
        
        for(int i = 2; i < index.size(); i += 2){
            int length = index.get(i) - end;
            res = (res * length) % mod;
            end = index.get(i + 1);
        }
        
        return (int) res;
    }
}