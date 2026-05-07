class Solution {
    public int minPartitions(String n) {
        int max=0;
        for(int i=0; i<n.length(); i++){
            char ch=n.charAt(i);
            int a = ch-'0';  /// isse string integer mein convert hota hai
            max=Math.max(max,a);
        }
        return max;
    }
}