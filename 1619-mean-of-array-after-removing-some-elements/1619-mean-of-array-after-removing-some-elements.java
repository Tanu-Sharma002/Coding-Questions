class Solution {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int percent = arr.length / 20; 
        int sum = 0;
        int count =0;
        for (int i=percent; i<arr.length-percent; i++) {
            sum += arr[i];
            count++;
        }
        return (double) sum / count;
    }
}
