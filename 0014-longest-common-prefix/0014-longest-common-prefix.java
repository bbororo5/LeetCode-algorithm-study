class Solution {
    public String longestCommonPrefix(String[] strs) {
        //0. strs 빈 요소인지 체크하기
        if (strs == null || strs.length == 0) {
            return null;
        }
        //1. 0번 요소를 먼저 prefix로 등록
        StringBuilder prefix = new StringBuilder(strs[0]);
        
        for (String element : strs) {
            //2. 그 다음 요소 길이체크하여, 그 다음 요소가 더 길다면 짜르기 패스, 그 다음 요소가 더 짧다면 그 길이에 맞게 prefix 자르기
            if (element.length() < prefix.length()) {
                prefix.delete(element.length(), prefix.length());
            }

            //3. 이어서, 요소와 한글자씩 대조하여, 같다면 냅두고, 다르다면 현재 포인터를 기점으로 뒤 모두 자르기.
            for (int i = 0; i < prefix.length(); i++) {
                if (element.charAt(i) != prefix.charAt(i)) {
                    prefix.delete(i, element.length());
                }
                 //4. prefix가 비었는지 체크후, 비었다면 그대로 종료.
                if (prefix.equals(null) || prefix.length() == 0) {
                    break;
                }
            }
        }
        return prefix.toString();
    }
}