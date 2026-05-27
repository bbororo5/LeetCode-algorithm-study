class Solution {
    public int findMinDifference(List<String> timePoints) {
        if(timePoints.size() > 1440) {
            return 0;
        }

        int current = Integer.MAX_VALUE;
        List<Integer> times = new ArrayList<>();

        for(String timePoint : timePoints) {
            String[] parts = timePoint.split(":");
            String hour = parts[0];
            String minute = parts[1];

            int h = Integer.parseInt(hour);
            int m = Integer.parseInt(minute);

            times.add(h * 60 + m);
        }

        Collections.sort(times);

        for(int i = 0; i < times.size() - 1; i++) {
            int val = times.get(i+1) - times.get(i);
            current = Math.min(val, current);
        }

        current = Math.min(current, times.get(0) + 1440 - times.get(times.size() - 1));

        return current;
    }
}