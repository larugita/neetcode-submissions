class Solution {
    public String longestCommonPrefix(String[] strs) {

        String word = strs[0];
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);

            for(String s : strs){
                if(i == s.length() || s.charAt(i) != c){
                    return result.toString();
                }
            }
            result.append(c);
        }
        return result.toString();
    }
}