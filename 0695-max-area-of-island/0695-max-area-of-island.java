class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[0].length; c++) {
                if(grid[r][c] == 1 && !visited[r][c]) {
                    int currentArea = bfs(r, c, grid, visited);
                    maxArea = Math.max(maxArea, currentArea);
                }
            }
        }

        return maxArea;
    }

    private int bfs(int r, int c, int[][] grid, boolean[][] visited) {
        int[] dr = new int[]{0, 1, -1, 0};
        int[] dc = new int[]{1, 0, 0, -1};
        visited[r][c] = true;
        int area = 1;

        for(int i = 0; i < 4; i++) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];

            if(nextR >= 0 && nextR < grid.length && nextC >= 0 && nextC < grid[0].length && visited[nextR][nextC] == false && grid[nextR][nextC] == 1) {
                area += bfs(nextR, nextC, grid, visited);
            }
        }
        
        return area;
    }
}