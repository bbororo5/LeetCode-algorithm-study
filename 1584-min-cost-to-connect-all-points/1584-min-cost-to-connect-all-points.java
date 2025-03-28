class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        // 최소 비용을 저장할 배열 (초기값: 무한대)
        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        // 첫 번째 점을 시작점으로 하여 비용 0 설정
        minCost[0] = 0;
        
        // 각 점의 포함 여부 체크
        boolean[] inMST = new boolean[n];
        // 최소 비용 우선순위 큐: [비용, 점 인덱스]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0});
        
        int totalCost = 0;
        int edgesUsed = 0;
        
        while (!pq.isEmpty() && edgesUsed < n) {
            int[] curr = pq.poll();
            int cost = curr[0], point = curr[1];
            
            // 이미 MST에 포함된 점이면 넘어감
            if (inMST[point]) continue;
            
            // MST에 포함시키고 총 비용 갱신
            inMST[point] = true;
            totalCost += cost;
            edgesUsed++;
            
            // 현재 점을 기준으로 나머지 점들과의 연결 비용(맨해튼 거리) 갱신
            for (int next = 0; next < n; next++) {
                if (!inMST[next]) {
                    int newCost = Math.abs(points[point][0] - points[next][0]) +
                                  Math.abs(points[point][1] - points[next][1]);
                    if (newCost < minCost[next]) {
                        minCost[next] = newCost;
                        pq.offer(new int[]{newCost, next});
                    }
                }
            }
        }
        
        return totalCost;
    }
}