class Solution {
    public int climbStairs(int n) {
        List<Integer> dp = new ArrayList<>();

        dp.add(0, 1);
        dp.add(1, 2);
        
        if (n > 1) {
            for (int i = 2; i < n; i++) {
                dp.add(i, dp.get(i - 1) + dp.get(i - 2));
            }
        }
        
        return dp.get(n - 1);
    }
}