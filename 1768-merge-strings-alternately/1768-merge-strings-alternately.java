class Solution {
    public String mergeAlternately(String word1, String word2) {
        char[] word1Array = word1.toCharArray();
        char[] word2Array = word2.toCharArray();

        StringBuilder sb = new StringBuilder();
        int left = 0;
        int right = 0;
        int cp = 0;
        
        while (left <= word1Array.length - 1 || right <= word2Array.length - 1) {
            if (cp == 0) {
                if (left < word1Array.length ) {
                    sb.append(word1Array[left]);
                    cp = 1;
                    left++;
                    continue;
                } else {
                    cp = 1;
                    continue;
                }
            }
            
            if(cp == 1) {
                if (right < word2Array.length) {
                    sb.append(word2Array[right]);
                    cp = 0;
                    right++;
                    continue;
                } else {
                    cp = 0;
                    continue;
                }
            }
        }

        return sb.toString();
    }
}