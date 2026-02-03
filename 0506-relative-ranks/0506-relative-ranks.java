import java.util.*;

class Solution {

    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] result = new String[n];

        int[] copy = Arrays.copyOf(score, n);
        Arrays.sort(copy);

        for (int i = 0; i < n; i++) {
            int rank = binarySearch(copy, score[i], n);

            if (rank == 1) {
                result[i] = "Gold Medal";
            } else if (rank == 2) {
                result[i] = "Silver Medal";
            } else if (rank == 3) {
                result[i] = "Bronze Medal";
            } else {
                result[i] = String.valueOf(rank);
            }
        }
        return result;
    }

    private int binarySearch(int[] arr, int target, int n) {
        int start=0, end=n-1;
        while (start<=end) {
            int mid=start+(end-start)/2;
            if (arr[mid]==target) {
                return n-mid;  
            } else if (arr[mid]<target) {
                start=mid + 1;
            } else {
                end=mid-1;
            }
        }
        return -1;
    }
}
