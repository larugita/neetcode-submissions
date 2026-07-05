class Solution {
    public boolean isPalindrome(String s) {

        char[] arr = s.toCharArray();

        String word = "";

        for(char c : arr){
            if(Character.isLetterOrDigit(c)){
                word += c;
            }
        }

        String reversed = "";

        for(int i = word.length() - 1; i >=0; i--){
            reversed += word.charAt(i);
        }

        word = word.toLowerCase();
        reversed = reversed.toLowerCase();

        if(word.equals(reversed)) return true;

        return false;
        
    }
}
