class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap <Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            if(!map.containsKey(num)){
                map.put(num, 1);
            }
            else{
                map.put(num, map.get(num) + 1);
            }
        }

        List<Integer> [] bucket = new List[nums.length + 1];

        for(int number : map.keySet()){
            int freq = map.get(number);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(number);
        }

        int[] result = new int[k];
        int index = 0;

        for(int i = bucket.length-1; i >= 0; i--){
            if(bucket[i] != null){
                for(int num : bucket[i]){
                    result[index] = num;
                    index++;
                }
            }
            if(index == k) return result;
        }
        return result;
    }
}
