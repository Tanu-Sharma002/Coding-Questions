class Solution {
    public boolean judgeCircle(String moves) {
        int left =0; 
        int right=0;
        int up=0;
        int down=0;
        for(int i=0; i<moves.length(); i++){
            char ch = moves.charAt(i);
            if(ch=='L') left++;
            if(ch=='R') right++;
            if(ch=='U') up++;
            if(ch=='D') down++;
        }
        return (left==right && up==down);
    }
}