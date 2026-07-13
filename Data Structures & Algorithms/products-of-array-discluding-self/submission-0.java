class Solution {
    public int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            int j = 1;
            int count = 0;
            while(count < nums.length){
                if(count != i){
                    j *= nums[count];
                }
                count++;
            }
            result[i] = j;
        }
        return result;
    }
}  
