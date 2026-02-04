class Solution {
    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        int mod = 1000000007;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);  
        int sum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum % 2 == 0) {
                if (map.containsKey(1)) {
                    count = (count + map.get(1)) % mod;
                }
                map.put(0, map.getOrDefault(0, 0) + 1);
            } else {
                if (map.containsKey(0)) {
                    count = (count + map.get(0)) % mod;
                }
                map.put(1, map.getOrDefault(1, 0) + 1);
            }
        }
        return count;
    }
}
