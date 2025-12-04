class Solution {
    public int countCollisions(String directions) {
        int n = directions.length();
        int left = 0, right = n - 1;
        while (left < n && directions.charAt(left) == 'L') {
            left++;
        }
        while (right >= 0 && directions.charAt(right) == 'R') {
            right--;
        }
        int collisions = 0;
        for (int i = left; i <= right; i++) {
            char ch = directions.charAt(i);
            if (ch == 'L' || ch == 'R') {
                collisions++;
            }
        }
        return collisions;
    }
}
