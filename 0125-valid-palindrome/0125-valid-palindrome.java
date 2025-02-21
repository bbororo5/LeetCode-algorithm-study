class Solution {
    public boolean isPalindrome(String s) {
        // 1. 소문자 변환 및 알파벳 외 모든 문자 제거
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        // 2. 빈 문자열인지 확인
        if (s.isEmpty()) {
            return true;
        }

        // 3. 대칭 검사
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}