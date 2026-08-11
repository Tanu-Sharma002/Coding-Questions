class Solution {
    public int[] arrayRankTransform(int[] arr) {
       int ans[] = new int[arr.length];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        int a=set.size();
        int nums[] = new int[a];
        int j=0;
        for(int s:set){
            nums[j]=s;
            j++;
        }
        Arrays.sort(nums);
        for (int i = 0; i < arr.length; i++) {
            binarySearch(i, nums, arr[i], ans);
        }
        return ans;
    }

    void binarySearch(int i, int nums[], int ele, int ans[]) {
        int low = 0;
        int high = nums.length - 1;
        int rank = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == ele) {
                rank = mid;
                high = mid - 1;
            } else if (nums[mid] < ele) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        ans[i] = rank + 1;
    }
}