class Solution {
    public String longestCommonPrefix(String[] strs) {

        String word = strs[0];
        String result = "";

        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);

            for(String s : strs){
                if(i == s.length() || s.charAt(i) != c){
                    return result;
                }
            }
            result += c;
        }
        return result;
    }
}