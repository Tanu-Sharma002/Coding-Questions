class MedianFinder {
    List<Integer> list = new ArrayList<>();

    public void addNum(int num) {
        int left = 0, right = list.size();

        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) < num) left = mid + 1;
            else right = mid;
        }

        list.add(left, num);
    }

    public double findMedian() {
        int n = list.size();
        if (n % 2 != 0) return list.get(n / 2);
        return (list.get(n / 2 - 1) + list.get(n / 2)) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */