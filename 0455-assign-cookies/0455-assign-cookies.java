class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if (s.length == 0) return 0;

        Arrays.sort(g);
        Arrays.sort(s);

        int lp = 0;
        int rp = 0;
        int count = 0;
        while(lp < g.length && rp < s.length) {
            if (g[lp] <= s[rp]) {
                count++;
                lp++;
            }
            rp++;
        }

        return count;
    }
}