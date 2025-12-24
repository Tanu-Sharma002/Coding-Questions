class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();
        for(int i=0; i<emails.length; i++){
            String[] parts = emails[i].split("@");
            String local=parts[0];
            String domain=parts[1];
            int plusIdx = local.indexOf("+");
            if(plusIdx != -1){
                local=local.substring(0,plusIdx);
            }
            local=local.replace(".","");
            set.add(local +"@"+ domain);
        }
        return set.size();
    }
}