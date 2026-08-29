class Solution {
    public int characterReplacement(String s, int k) {

        HashMap<Character, Integer> count = new HashMap<>();

        int longest = 0;
        int left = 0;

        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            if(!count.containsKey(c)) count.put(c , 1);
            else count.put(c , count.get(c) + 1);

            int maxfreq = 0;
            for(int freq : count.values()){
                maxfreq = Math.max(maxfreq, freq);
            }

            while((right - left + 1) - maxfreq > k){
                count.put(s.charAt(left), count.get(s.charAt(left))-1);
                left++;

                maxfreq = 0;
                for(int freq : count.values()){
                    maxfreq = Math.max(maxfreq, freq);
                }
            }

            longest = Math.max(longest, right - left + 1);
        }
        return longest;
    }
}