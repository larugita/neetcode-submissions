class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num : nums){
            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
            }
            else{
                map.put(num, 1);
            }
        }

        List<Integer> [] bucket = new List[nums.length+1];

        for(int num : map.keySet()){
            int freq = map.get(num);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(num);
        }

        int[] result = new int[k];
        int index = 0;

        for(int i = nums.length; i >= 0; i--){
            if(bucket[i] != null){
                for(int num : bucket[i]){
                    result[index] = num;
                    index++;
                    if(index == k) return result;
                }
            }
        }

        return result;
        
    }
}
