class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        char[] number = Integer.toString(x).toCharArray();
        int left = 0;
        int right = number.length - 1;
        while(left < right) {
            if (!(number[left] == number[right])) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}