class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) {
            return image;
        }
        
        bfs(image, sr, sc, image[sr][sc], color);

        return image;
    }

    private void bfs(int[][] image, int sr, int sc, int oldColor, int newColor) {
        int[] dr = new int[]{-1, 1, 0, 0};
        int[] dc = new int[]{0, 0, -1, 1};
        image[sr][sc] = newColor;

        for(int i = 0; i < 4; i++) {
            int nextR = sr + dr[i];
            int nextC = sc + dc[i];

            if(nextR >= 0 && nextR < image.length 
                && nextC >= 0 && nextC < image[0].length
                && image[nextR][nextC] == oldColor) {
                    bfs(image, nextR, nextC, oldColor, newColor);
                }
        }
    }
}