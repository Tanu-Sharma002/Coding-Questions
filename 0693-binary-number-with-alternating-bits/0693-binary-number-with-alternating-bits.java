class Solution {
    public boolean hasAlternatingBits(int n) {
        String a = Integer.toBinaryString(n);
        if(a.charAt(0) == '0'){
            for(int i=1; i<a.length(); i++){
                if(i%2==1 && a.charAt(i) != '1') return false;
                if(i%2==0 && a.charAt(i) != '0') return false;
            }
        }
        if(a.charAt(0) == '1'){
            for(int i=1; i<a.length(); i++){
                if(i%2==1 && a.charAt(i) != '0') return false;
                if(i%2==0 && a.charAt(i) != '1') return false;
            }
        }
        return true;
    }
}