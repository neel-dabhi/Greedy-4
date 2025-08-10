// TC: (n * log m) m = len of Source
// SC: O(m) m = len of Source
class Solution {
    public int shortestWay(String source, String target) {

        HashMap<Character, List<Integer>> map = new HashMap<>();

        for(int i=0; i< source.length(); i++){
            Character ch = source.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch, new ArrayList<Integer>());
            }
            map.get(ch).add(i);
        }
        int p1 = 0;
        int p2 = 0;
        int result = 1;

        while(p2 < target.length()){
            Character p1Char = source.charAt(p1);
            Character p2Char = target.charAt(p2);

            if(!map.containsKey(p2Char)){
                return -1;
            }

            List<Integer> list = map.get(p2Char);
            int index = Collections.binarySearch(list, p1);

            if(index < 0){
                index = -index-1;
            }

            if(index == list.size()){
                p1 = list.get(0);
                result++;
            }else{
                p1 = list.get(index);
            }
            p1++;
            p2++;
        }
        return result;
    }
}