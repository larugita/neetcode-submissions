class Solution {
    public int majorityElement(int[] nums) {

        int res = nums[0];
        int count = 0;

        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            if(num == res){
                count++;
            }
            else if(num != res && count != 0){
                count--;
            }
            else{
                res = num;
                count++;
            }
        }
        return res;
    }
}