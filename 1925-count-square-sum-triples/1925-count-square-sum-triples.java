class Solution {
    public int countTriples(int n) {
        int count = 0;
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                int sum = a*a + b*b;

                if (helper(sum, n)) {
                    count++;
                }
            }
        }
        return count;
    }
    static boolean helper(int sum, int n) {
        for (int c = 1; c <= n; c++) {
            if (c*c == sum) return true;
        }
        return false;
    }
}
