import java.util.*;

class Solution {
    public List<Integer> intersection(int[][] nums) {
        int n = nums.length;
        int[] count = new int[1001];
        for (int[] arr : nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : arr) {
                set.add(num);
            }
            for (int num : set) {
                count[num]++;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            if (count[i] == n) {
                result.add(i);
            }
        }
        return result;
    }
}
