class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0)
            return Collections.emptyList();
        int n = matrix[0].length;

        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        List<Integer> res = new ArrayList<>(m * n);

        while (res.size() < m * n) {
            // 1) 왼→오
            for (int c = left; c <= right; c++)
                res.add(matrix[top][c]);
            top++;

            // 2) 위→아래
            for (int r = top; r <= bottom; r++)
                res.add(matrix[r][right]);
            right--;

            // 3) 오른→왼
            if (top <= bottom) {
                for (int c = right; c >= left; c--)
                    res.add(matrix[bottom][c]);
                bottom--;
            }

            // 4) 아래→위
            if (left <= right) {
                for (int r = bottom; r >= top; r--)
                    res.add(matrix[r][left]);
                left++;
            }
        }
        return res;
    }
}