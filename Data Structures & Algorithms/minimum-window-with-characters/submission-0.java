class Solution {
    public String minWindow(String s, String t) {

        if(t.length() > s.length() || t.equals("")){
            return "";
        }

        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for(char c : t.toCharArray()){
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int have = 0, needCount = need.size();
        int resLeft = 0, resLength = Integer.MAX_VALUE;
        int left = 0;
        
        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);
            
            if(need.containsKey(c) && window.get(c).equals(need.get(c))){
                have++;
            }

            while(have == needCount){
                if(right - left + 1 < resLength){
                    resLength = right - left + 1;
                    resLeft = left;
                }

                window.put(s.charAt(left), window.get(s.charAt(left)) - 1);

                if(need.containsKey(s.charAt(left)) && window.get(s.charAt(left)) < need.get(s.charAt(left))){
                    have--;
                }

                left++;

            }
        }
        if(resLength == Integer.MAX_VALUE){
            return "";
        }
        return s.substring(resLeft, resLeft + resLength);
    }
}