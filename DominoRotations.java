// TC: O(n)
// SC: O(n)
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int curr : tops) {
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }
        for (int curr : bottoms) {
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }
        int potential = 0;
        for (int key : map.keySet()) {
            if (map.get(key) >= n) {
                potential = key;
            }
        }

        int aRot = 0;
        int bRot = 0;

        for (int i = 0; i < n; i++) {
            if( tops[i] != potential && bottoms[i] != potential){
                return -1;
            }
            if(tops[i] != potential){
                aRot++;
            }else if(bottoms[i] != potential){
                bRot++;
            }
        }
        return Math.min(aRot, bRot);
    }
}