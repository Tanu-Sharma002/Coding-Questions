import java.util.*;

class NumArray {
    int[] bit, nums;
    int n;
    public NumArray(int[] nums) {
        this.n = nums.length;
        this.nums = nums.clone();
        bit = new int[n + 1];
        for (int i = 0; i < n; i++) updateBIT(i, nums[i]);
    }
    private void updateBIT(int index, int delta) {
        index++;
        while (index <= n) {
            bit[index] += delta;
            index += index & -index;
        }
    }
    public void update(int index, int val) {
        int delta = val - nums[index];
        nums[index] = val;
        updateBIT(index, delta);
    }
    private int query(int index) {
        int sum = 0;
        index++;
        while (index > 0) {
            sum += bit[index];
            index -= index & -index;
        }
        return sum;
    }
    public int sumRange(int left, int right) {
        return query(right) - query(left - 1);
    }
}