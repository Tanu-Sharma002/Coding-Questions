class Solution {
    public int maximumCandies(int[] candies, long k) {
        int left = 1;
        int right = 0;
        for (int c : candies) {
            right = Math.max(right, c);
        }
        int answer = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long count = 0;
            for (int c : candies) {
                count += c / mid;
            }
            if (count >= k) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }
}
