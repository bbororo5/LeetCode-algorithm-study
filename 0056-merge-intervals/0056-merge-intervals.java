class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else if(!merged.isEmpty() && merged.getLast()[1] >= interval[0] && merged.getLast()[1] < interval[1]) {
                merged.getLast()[1] = interval[1];
            }
        }
        return merged.toArray(new int [merged.size()][2]);
    }
}