class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            int length = s.length();
            sb.append(length).append("#").append(s);
        }
        return sb.toString();
    }
    // 1#a1#b1#c
    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while(i < str.length()){
            int j = i;
            while(str.charAt(j) != '#'){
                j++;
            }
            int length = Integer.parseInt(str.substring(i,j));
            j++;
            result.add(str.substring(j, j+length));
            i=j+length;
        }
        return result;
    }
}
