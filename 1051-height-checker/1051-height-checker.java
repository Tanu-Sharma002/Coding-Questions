class Solution {
    public int heightChecker(int[] heights) {
        int h=heights.length;
        int num[]=new int[h];
        for(int i=0; i<h; i++){
            num[i]=heights[i];
        }
        int count=0;
        Arrays.sort(num);
        for(int i=0; i<h; i++){
            if(num[i] != heights[i]) count++;
        }
        return count;
    }
}