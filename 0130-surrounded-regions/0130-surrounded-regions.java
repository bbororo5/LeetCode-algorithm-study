import java.util.*;

class Solution {
    public void solve(char[][] board) {
        //좌표 이동 (상하좌우)
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        //테두리 먼저 진입
        int n = board.length;
        int m = board[0].length;

        Queue<int[]> queue = new ArrayDeque<>();

        //행 테두리
        for(int i = 0; i < m; i++) {
            if(board[0][i] == 'O') {
                board[0][i] = 'S';
                queue.offer(new int[]{0, i});
            }

            if(board[n-1][i] == 'O') {
                board[n-1][i] = 'S';
                queue.offer(new int[]{n-1, i});
            }
        }

        for(int j = 0; j < n; j++) {
            if(board[j][0] == 'O') {
                board[j][0] = 'S';
                queue.offer(new int[]{j, 0});
            }

            if(board[j][m-1] == 'O') {
                board[j][m-1] = 'S';
                queue.offer(new int[]{j, m-1});
            }
        }

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];

            for(int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];

                if(nr > 0 && nr < n && nc > 0 && nc < m && board[nr][nc] == 'O') {
                    queue.offer(new int[]{nr, nc});
                    board[nr][nc] = 'S';
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) {
                if(board[i][j] == 'S') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}