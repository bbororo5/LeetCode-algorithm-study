import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0 , -1, 1};

        int n = grid.length;
        int m = grid[0].length;
        int time = 0;
        Queue<int[]> queue = new ArrayDeque<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i, j, 0});
                }
            }
        }
    
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            time = cur[2];

            for(int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];

                if(nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2;
                    queue.offer(new int[]{nr, nc, time + 1});
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return time;
    }
}