class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times) {
            graph.putIfAbsent(time[0], new ArrayList<>());
            graph.get(time[0]).add(new int[]{time[1], time[2]});
        }
        
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, k});
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int d = current[0], node = current[1];

            if (d > dist[node]) continue;
        
            if (!graph.containsKey(node)) continue;
            
            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0];
                int travelTime = neighbor[1];
               
                if (dist[node] + travelTime < dist[nextNode]) {
                    dist[nextNode] = dist[node] + travelTime;
                    pq.offer(new int[]{dist[nextNode], nextNode});
                }
            }
        }
        
        int delay = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1; 
            }
            
            delay = Math.max(delay, dist[i]);
        }
        
        return delay;
    }
}