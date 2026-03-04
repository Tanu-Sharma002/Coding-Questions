class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..","--","-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };
        HashSet<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder trans = new StringBuilder();
            for (char c : word.toCharArray()) {
                trans.append(morse[c-'a']);
            }
            set.add(trans.toString());
        }
        return set.size();
    }
}