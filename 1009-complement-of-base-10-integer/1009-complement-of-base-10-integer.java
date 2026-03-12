class Solution {
    public int bitwiseComplement(int n) {
        String binary = Integer.toBinaryString(n);
        char arr[] = binary.toCharArray();
        for(int i=0; i<arr.length; i++){
            if(arr[i]=='1') arr[i]='0';
            else arr[i]='1';
        }
        String str = new String(arr); 
        int a = Integer.parseInt(str, 2); 
        return a;
    }
}