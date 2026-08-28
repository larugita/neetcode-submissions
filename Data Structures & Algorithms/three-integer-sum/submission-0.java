class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        ArrayList<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){

            // Skip duplicate first numbers
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }

            int sum = 0 - nums[i];

            int j = i + 1;
            int k = nums.length - 1;

            while(j < k){

                if(nums[j] + nums[k] < sum){
                    j++;
                }
                else if(nums[j] + nums[k] > sum){
                    k--;
                }
                else{
                    ArrayList<Integer> arr = new ArrayList<>();

                    arr.add(nums[i]);
                    arr.add(nums[j]);
                    arr.add(nums[k]);

                    result.add(arr);

                    j++;
                    k--;

                    // Skip duplicate second numbers
                    while(j < k && nums[j] == nums[j - 1]){
                        j++;
                    }

                    // Skip duplicate third numbers
                    while(j < k && nums[k] == nums[k + 1]){
                        k--;
                    }
                }
            }
        }

        return result;
    }
}