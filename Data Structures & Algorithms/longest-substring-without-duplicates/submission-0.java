class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;

        for(int i = 0; i < s.length(); i++){
            HashSet<Character> set = new HashSet<>();

            int length = 0;
            int j = i;

            while(j < s.length() && !set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                length++;
                j++;
            }

            if(length > maxLength) maxLength = length;
        }

        return maxLength;

    }
}