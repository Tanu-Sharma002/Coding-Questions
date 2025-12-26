class Solution {
    public String[] findWords(String[] words) {
        String r1 = "qwertyuiop";
        String r2 = "asdfghjkl";
        String r3 = "zxcvbnm";
        List<String> list = new ArrayList<>();
        for(String word:words){
            int rows[] = new int[3];
            for(char ch:word.toLowerCase().toCharArray()){
                if(r1.indexOf(ch)!=-1) rows[0]=1;
                else if(r2.indexOf(ch)!=-1) rows[1]=1;
                else rows[2]=1;
            }
            int sum=rows[0]+rows[1]+rows[2];
            if(sum==1) list.add(word);
        }  
        int i=0;
        String arr[]=new String[list.size()];
        for(String word:list){
            arr[i++]=word;
        }
        return arr;
    }
}