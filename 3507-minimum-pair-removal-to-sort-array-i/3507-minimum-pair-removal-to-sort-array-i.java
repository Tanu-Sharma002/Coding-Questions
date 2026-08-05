class Solution {
    public int minimumPairRemoval(int[] nums) {
        int ops = 0;
        List<Integer> list = new ArrayList<>();
        for (int v : nums) list.add(v);
        Function<List<Integer>, Boolean> isSorted = l -> {
            for (int i = 0; i + 1 < l.size(); i++) {
                if (l.get(i) > l.get(i + 1)) {
                    return false;
                }
            }
            return true;
        };

        while (!isSorted.apply(list)) {
            int minSum = Integer.MAX_VALUE, idx = -1;
            for (int i = 0; i + 1 < list.size(); i++) {
                int s = list.get(i) + list.get(i + 1);
                if (s < minSum) {
                    minSum = s;
                    idx = i;
                }
            }
            list.set(idx, minSum);
            list.remove(idx + 1);
            ops++;
        }

        return ops;
    }
}
