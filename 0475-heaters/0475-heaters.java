class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int i=0;
        int radius = 0;
        int n = heaters.length;
        for (int house : houses) {
            while (i < n - 1 && Math.abs(heaters[i + 1] - house) <= Math.abs(heaters[i] - house)) {
                i++;
            }
            int dist = Math.abs(heaters[i] - house);
            if (dist > radius) {
                radius = dist;
            }
        }
        return radius;
    }
}