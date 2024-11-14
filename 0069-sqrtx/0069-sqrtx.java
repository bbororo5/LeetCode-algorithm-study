class Solution {
    public int mySqrt(int x) {
        long left = 0;
        long right = x;
        long mid = 0;

        while(left <= right) {
            mid = left + (right - left)/2;
            long square = mid * mid;

            if (square <= x && (mid + 1) * (mid + 1) > x) {
                return (int)mid;
            } else if (square < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return (int)mid;
    }
}