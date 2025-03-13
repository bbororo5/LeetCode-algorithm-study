class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 1) {
            return 1;
        }

        Arrays.sort(points, (a, b) -> {
            if (a[1] == b[1]) return 0;
            if (a[1] < b[1]) return -1;
            return 1;
        });

        int arrows = 1;
        int currentStart, currentEnd;
        int firstEnd = points[0][1];
        for (int[] p : points) {
            currentStart = p[0];
            currentEnd = p[1];

            if (firstEnd < currentStart) {
                arrows++;
                firstEnd = currentEnd;
            }
        }

        return arrows;
    }
}