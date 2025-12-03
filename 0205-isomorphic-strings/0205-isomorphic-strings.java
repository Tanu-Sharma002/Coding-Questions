class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Character> mp = new HashMap<>();
        HashSet<Character> used = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char sCh = s.charAt(i);
            char tCh = t.charAt(i);
            if (mp.containsKey(sCh)) {
                if (mp.get(sCh) != tCh) return false;
            } else {
                if (used.contains(tCh)) return false;
                mp.put(sCh, tCh);
                used.add(tCh);
            }
        }
        return true;
    }
}
