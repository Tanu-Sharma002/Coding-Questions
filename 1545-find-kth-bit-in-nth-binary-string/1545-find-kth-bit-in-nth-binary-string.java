class Solution {
    public char findKthBit(int n, int k) {
        String s="0" ;
        for(int i=2; i<=n; i++){
            s=s+"1"+reverse(invert(s));
        }
        return s.charAt(k-1);
    }
    public static String invert(String str) {
        char[] arr = str.toCharArray();
        for(int i=0; i<arr.length; i++){
            if(arr[i]=='0') arr[i]='1';
            else arr[i]='0';
        }
        return new String(arr);
    }
    public static String reverse(String str) {
        char[] arr = str.toCharArray();
        int start = 0;
        int end = arr.length - 1;
        while (start<end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return new String(arr);
    }
}