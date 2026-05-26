class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int answer = 0;
        while (answer<costs.length && costs[answer]<=coins) {
            coins -= costs[answer];
            answer += 1;
        }
        return answer;
    }
}
