class Solution {
    /*
        // 초기화: 방문 배열(visited), 결과 리스트(result), 초기 방향(우측), 위치(0,0)

        while (결과 리스트의 크기 < 전체 행렬 크기):
            1. 현재 위치를 방문 처리하고 결과 리스트에 추가
            2. 다음 예상 좌표를 계산 (현재 위치 + 현재 방향)
    
            3. if (다음 좌표가 경계 안인가? AND 방문하지 않았는가?):
                그 위치로 이동
                else:
                    방향을 시계방향으로 회전 (인덱스 변화)
                    새로운 방향으로 위치 갱신
           
        return 결과 리스트
    */

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        List<Integer> result = new ArrayList<>();
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int dir = 0;
        int x = 0, y = 0;
        int matrixSize = m * n;

        while(result.size() < matrixSize) {
            if(!visited[x][y]) {
                visited[x][y] = true;
                result.add(matrix[x][y]);
            }
            
            int nextX = x + dx[dir];
            int nextY = y + dy[dir];

            if(nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && visited[nextX][nextY] == false) {    
                x = nextX;
                y = nextY;
            } else {
                dir = (dir + 1) % 4; 
            }

        }

        return result;
    }
}