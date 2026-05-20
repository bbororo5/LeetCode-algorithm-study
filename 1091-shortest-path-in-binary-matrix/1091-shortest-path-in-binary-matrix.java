class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int maxR = grid.length;
        int maxC = grid[0].length;

        if (grid[0][0] == 1 || grid[maxR - 1][maxC - 1] == 1) {
            return -1;
        }

        int[] dr = {-1, 1, 0, 0, -1, 1, 1, -1};
        int[] dc = {0, 0, -1, 1, -1, -1, 1, 1};

        Queue<int[]> queue = new LinkedList<>();
        int distance = 1;
        queue.add(new int[]{0, 0});
        grid[0][0] = 0;

        while(!queue.isEmpty()) {
            int levelSize = queue.size();

            for(int i = 0; i < levelSize; i++) {
                int[] current = queue.poll();
                int currentR = current[0];
                int currentC = current[1];

            
                if (currentR == maxR - 1 && currentC == maxC - 1) {
                    return distance;
                }

                for (int d = 0; d < 8; d++) {
                    int nextR = currentR + dr[d];
                    int nextC = currentC + dc[d];

                    if(nextR >= 0 && nextR < maxR && nextC >= 0 && nextC < maxC && grid[nextR][nextC] == 0) {
                        queue.add(new int[]{nextR, nextC});
                        grid[nextR][nextC] = 1;
                    }
                }
            }

            distance++;
        }

        return -1;
    }
}