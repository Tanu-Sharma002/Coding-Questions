class Solution {
    Integer[][] dp;
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        dp = new Integer[piles.size()][k + 1];
        return solve(0, k, piles);
    }
    private int solve(int i, int k, List<List<Integer>> piles) {
        if (i == piles.size() || k == 0) return 0;
        if (dp[i][k] != null) return dp[i][k];
        int res = solve(i + 1, k, piles);
        int currentPileSum = 0;
        for (int j = 0; j < Math.min(piles.get(i).size(), k); j++) {
            currentPileSum += piles.get(i).get(j);
            res = Math.max(res, currentPileSum + solve(i + 1, k - (j + 1), piles));
        }
        return dp[i][k] = res;
    }
}
