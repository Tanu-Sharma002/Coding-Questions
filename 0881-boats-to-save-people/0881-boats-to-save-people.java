class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int i=0;
        int j=people.length;
        Arrays.sort(people);
        int count=0;
        while(i<j){
            if(people[i]+people[j-1]<=limit){
                i++;
                j--;
            } else {
                j--;
            }
            count++;
        }
        return count;
    }
}