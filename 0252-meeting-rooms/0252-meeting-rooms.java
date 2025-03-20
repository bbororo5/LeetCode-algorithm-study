class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length == 0 || intervals == null) {
            return true;
        }

        Arrays.sort(intervals, (o1, o2) -> {
            if (o1 == o2) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        int ei = intervals[0][1];
        boolean result = true;

        for(int i = 1; i < intervals.length; i++) {
            if( ei <= intervals[i][0]) {
                ei = intervals[i][1];
                continue;
            } else {
                return false;
            }
        }

        return result;
    }
}