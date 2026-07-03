class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap <Integer, Integer> map = new HashMap<>();

        for(int i : nums){
            if(!map.containsKey(i)){
                map.put(i,1);
            }
            else{
                map.put(i,map.get(i) + 1);
            }
        }

        List <Integer> [] bucket = new List [nums.length + 1];

        for(int num : map.keySet()){
            int freq = map.get(num);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(num);
        }

        int count = 0;
        int[] result = new int[k];

        for(int i = bucket.length - 1; i >= 0; i--){
            if(bucket[i] != null){
                for(int num : bucket[i]){
                    result[count] = num;
                    count++;
                }
            }
            if(count == k) return result;
        }
        return result;
    }
}
