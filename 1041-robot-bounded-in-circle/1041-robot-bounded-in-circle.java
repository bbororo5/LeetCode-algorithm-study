class Solution {
    public boolean isRobotBounded(String instructions) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};
        int dir = 0;

        int x = 0, y = 0;

        char[] a = instructions.toCharArray();
        for(char instruction : a) {
            switch (instruction) {
                case 'G' -> {
                    x += dx[dir];
                    y += dy[dir];
                } 
                case 'L' -> {
                    dir = (dir + 3) % 4;
                }

                case 'R' -> {
                    dir = (dir + 1) % 4;
                }
            }
        }

        return x == 0 && y == 0 || (dir != 0);
    }
}