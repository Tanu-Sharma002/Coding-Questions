class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        List<Integer> row=new ArrayList<>();
        List<Integer> col=new ArrayList<>();
        for(int i=0;i<m;i++){
            int minimum=Integer.MAX_VALUE;
            for(int j=0;j<n;j++){
                minimum=Math.min(matrix[i][j],minimum);
            }
            row.add(minimum);
        }
        for(int i=0;i<n;i++){
            int maximum=Integer.MIN_VALUE;
            for(int j=0;j<m;j++){
                maximum=Math.max(matrix[j][i],maximum);
            }
            col.add(maximum);
        }
        List<Integer> res=new ArrayList<>();
        for(int num:row){
            if(col.contains(num)){
                res.add(num);
            }
        }
        return res;
    }
}