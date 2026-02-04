class Solution {
    public int numOfSubarrays(int[] arr) {

        int MOD = 1_000_000_007;

        int even = 1; // prefixSum = 0 (even)
        int odd = 0;

        int sum = 0;
        int count = 0;

        for (int num : arr) {
            sum += num;

            if (sum % 2 == 0) {
                // even - odd = odd subarray
                count = (count + odd) % MOD;
                even++;
            } else {
                // odd - even = odd subarray
                count = (count + even) % MOD;
                odd++;
            }
        }

        return count;
    }
}
