class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int i = 0;
        int j = numbers.length - 1;

        while(i < j){
            while(numbers[i] + numbers[j] > target && i < j){
                j--;
            }
            while(numbers[i] + numbers[j] < target && i < j){
                i++;
            }
            if(numbers[i] + numbers[j] == target) return new int[]{i+1,j+1};
        }
        return null;
    }
}
