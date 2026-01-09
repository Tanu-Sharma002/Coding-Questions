class Solution {
    public String makeGood(String s) {
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!st.isEmpty() && Math.abs(st.peek() - c) == 32) {    // same alphabet ke upper or lower ASCII ka   difference 32 hota hai.
                st.pop();
            } else {
                st.push(c);
            }
        }
        StringBuilder res = new StringBuilder();
        for (char c : st) {
            res.append(c);
        }
        return res.toString();
    }
}