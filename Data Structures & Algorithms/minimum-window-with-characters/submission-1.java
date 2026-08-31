class Solution {
    public String minWindow(String s, String t) {

        if(t.length() > s.length() || t.length() == 0) return "";

        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for(char c : t.toCharArray()){
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int needCount = need.size();
        int haveCount = 0;
        int left = 0;
        int windowSize = Integer.MAX_VALUE;
        int resLeft = 0;
        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if(need.containsKey(c)){
                if(need.get(c).equals(window.get(c))){
                    haveCount++;
                }
            }
            
            while(haveCount == needCount){
                int size = right - left + 1;
                if(size < windowSize){
                    windowSize = size;
                    resLeft = left;
                }

                window.put(s.charAt(left), window.get(s.charAt(left)) - 1);

                if(need.containsKey(s.charAt(left)) && window.get(s.charAt(left)) < need.get(s.charAt(left))){
                    haveCount--;
                }

                left++;
            }
        }

        if(windowSize == Integer.MAX_VALUE) return "";

        return s.substring(resLeft, resLeft + windowSize);
        
    }
}