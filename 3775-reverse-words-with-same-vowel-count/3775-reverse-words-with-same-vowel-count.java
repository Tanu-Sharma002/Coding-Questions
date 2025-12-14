class Solution {
    public String reverseWords(String s) {
        String t = s;
        String[] words = t.split(" ");

        int firstCount = 0;
        for (char ch : words[0].toCharArray()) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                firstCount++;
            }
        }

        for (int i = 1; i < words.length; i++) {
            int count = 0;
            for (char ch : words[i].toCharArray()) {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    count++;
                }
            }

            if (count == firstCount) {
                words[i] = new StringBuilder(words[i]).reverse().toString();
            }
        }

        return String.join(" ", words);
    }
}
