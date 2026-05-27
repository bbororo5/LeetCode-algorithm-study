class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] a = new int[26];

        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        for(int i = 0; i < sc.length; i++) {
            a[sc[i] - 'a']++;
        }

        for(int j = 0; j < tc.length; j++) {
            a[tc[j] - 'a']--;
        }

        for(int k = 0; k < a.length; k++) {
            if(a[k] != 0) {
                return false;
            }
        }

        return true;
    }
}