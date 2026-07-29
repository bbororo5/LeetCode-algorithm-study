import java.util.*;

class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        
        if (deadSet.contains("0000")) return -1;

        Queue<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        
        queue.offer("0000");
        visited.add("0000");

        int level = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                String current = queue.poll();
            

                if(current.equals(target)) {
                    return level;
                }

                for(int j = 0; j<4; j++) {
                    char c = current.charAt(j);

                    char up = c == '9' ? '0' : (char)(c+1);
                    char down = c == '0' ? '9' : (char)(c - 1);

                    String nextUp = current.substring(0, j) + up + current.substring(j + 1);
                    String nextDown = current.substring(0, j) + down + current.substring(j + 1);

                    
                    if (!deadSet.contains(nextUp) && !visited.contains(nextUp)) {
                        visited.add(nextUp);
                        queue.offer(nextUp);
                    }
                        
                    
                    if (!deadSet.contains(nextDown) && !visited.contains(nextDown)) {
                        visited.add(nextDown);
                        queue.offer(nextDown);
                    }
                }
            }

            level++;
        }

        return -1;
    }
}