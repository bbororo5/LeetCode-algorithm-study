class Solution {
    public int numIslands(char[][] grid) {
        int[] dr = {-1 , 1 , 0, 0};
        int[] dc = {0, 0, -1, 1};

        int islandCount = 0;

        int maxRow = grid.length;
        int maxCol = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for (int r = 0; r < maxRow; r++) {
            for (int c = 0; c < maxCol; c++) {
                if(grid[r][c] == '1') {
                    islandCount++;
                    queue.add(new int[]{r, c});
                    grid[r][c] = '0';

                    while(!queue.isEmpty()) {
                        int[] current = queue.poll();
                        int curR = current[0];
                        int curC = current[1];

                        for (int i = 0; i < 4; i++) {
                            int nextR = curR + dr[i];
                            int nextC = curC + dc[i];
                            
                            if (nextR >= 0 && nextR < maxRow && nextC >= 0 && nextC < maxCol && grid[nextR][nextC] == '1') {
                                queue.add(new int[]{nextR, nextC});
                                grid[nextR][nextC] = '0';
                            }
                        }
                    }
                }
            }
        }

        return islandCount;
    }
}