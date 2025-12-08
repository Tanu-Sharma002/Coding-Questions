class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        int zeroCount = 0;
        for (int num : arr) {
            if (num == 0) zeroCount++;
            set.add(num);
        }

        if (zeroCount >= 2) return true;  

        for (int num : arr) {
            if (num != 0 && set.contains(2 * num)) {
                return true;
            }
        }
        return false;
    }
}
