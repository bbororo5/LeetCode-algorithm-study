class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.equals(null) || s.length() == 0) {
            return 0;
        }

        int longestLength = 0;
        int left = 0;
        int right = 1;
        while (left < right && right <= s.length()) {
            String currentWindow = s.substring(left, right);

            StringBuilder sb = new StringBuilder();
            Set<String> set = new HashSet<>();
            for (char c : currentWindow.toCharArray()) {
                if (set.add(String.valueOf(c))) {
                    sb.append(c);
                }
            }

            // 중복이 있는 경우
            if (sb.length() != currentWindow.length()) {
                left++;
            } 

            //가장 긴 window 기록 최신화
            int currecntLength = sb.length();
            if (currecntLength > longestLength) {
                longestLength = currecntLength;
            }

            right++;
        }

        return longestLength;
    }
}