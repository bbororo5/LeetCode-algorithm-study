class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];

        if(oldColor == color) {
            return image;
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{sr, sc});
        image[sr][sc] = color;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];

            // System.out.printf(">> 현재 방문: (%d, %d)\n", r, c);
            for(int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];

                if(nr >= 0 && nr < image.length && nc >= 0 && nc < image[0].length && image[nr][nc] == oldColor) {
                    queue.offer(new int[]{nr, nc});
                    image[nr][nc] = color;
                    // System.out.printf("nr : %d, nc : %d, color: %d\n",nr, nc, image[nr][nc]);
                }
            }
        }

        return image;
    }
}