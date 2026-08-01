class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int majority = nums.length/2;
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            if(map.containsKey(num)) map.put(num, map.get(num) + 1);
            else map.put(num, 1);
        }
        for(int num : map.keySet()){
            if(map.get(num) > majority) return num;
        }

        return 0;
        
    }
}