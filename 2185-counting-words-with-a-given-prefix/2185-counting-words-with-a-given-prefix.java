class Solution {
    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for (String w : words) {
            if (w.startsWith(pref)) count++;
        }
        return count;
    }
}
/* 
method 2
class Solution {
    public int prefixCount(String[] words, String pref) {
        int count = 0;
        int m = pref.length();

        for (String word : words) {
            if (word.length() < m) continue; 

            int j = 0;
            while (j < m && word.charAt(j) == pref.charAt(j)) {
                j++;
            }
            if (j == m) count++;
        }
        return count;
    }
}
*/
