class Solution {
    public int findMinDifference(List<String> timePoints) {
        if(timePoints.size() > 1440) {
            return 0;
        }

        int current = Integer.MAX_VALUE;
        List<Integer> times = new ArrayList<>();

        for(String timePoint : timePoints) {
            /*GC최적화 포인트: Split 대신 charAt 아스키 연산으로 힙 메모리 할당 제로화
            int h = (timePoint.charAt(0) - '0') * 10 + (timePoint.charAt(1) - '0')
            int m = (timePoint.charAt(3) - '0') * 10 + (timePoint.charAt(4) - '0')
            */
            String[] parts = timePoint.split(":");
            String hour = parts[0];
            String minute = parts[1];
            int h = Integer.parseInt(hour);
            int m = Integer.parseInt(minute);

            times.add(h * 60 + m);
        }

        Collections.sort(times);

        for(int i = 0; i < times.size() - 1; i++) {
            //변수 할당을 하지 않음으로써, unboxing 연산을 제거할 수 있었음.
            int val = times.get(i+1) - times.get(i);
            current = Math.min(val, current);
        }

        int circularDiff = times.get(0) + 1440 - times.get(times.size() - 1);
        return Math.min(current, circularDiff);
    }
}