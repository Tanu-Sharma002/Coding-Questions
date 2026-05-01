import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : deck) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        for (int count : map.values()) {
            int a = res;
            int b = count;
            while (b > 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            res = a;
        }
        return res >= 2;
    }
}
