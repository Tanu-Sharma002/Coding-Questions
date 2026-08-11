class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sumA=0;
        for(int i=0; i<aliceSizes.length; i++){
            sumA += aliceSizes[i];
        }
        int sumB=0;
        for(int i=0; i<bobSizes.length; i++){
            sumB += bobSizes[i];
        }
        Set<Integer> set=new HashSet<>();
        int diff=(sumB-sumA)/2;
        for(int b:bobSizes) set.add(b);
        for (int a:aliceSizes) {
            if(set.contains(a+diff)){
                return new int[]{a, a+diff};
            }
        }
        return new int[]{};
    }
}