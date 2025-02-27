class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s.equals(null) || s.length() == 0) {
            return 0;
        }

        int left = 0, maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);

            // 윈도우 내 서로 다른 문자의 수가 2개를 초과하면, 조건을 만족할 때까지 left를 이동시킵니다.
            while (map.size() > 2) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }
            
            // 윈도우 길이 갱신 (현재 right가 포함된 상태이므로 right - left + 1)
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}