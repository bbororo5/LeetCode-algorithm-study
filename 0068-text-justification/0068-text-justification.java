class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        Deque<String> queue = new LinkedList<>();
        int lineChars = 0;

        //중간 줄 처리
        int idx = 0;
        while (idx < words.length) {
            String w = words[idx];
            queue.addLast(w);
            lineChars += w.length();

            int widthWithSpaces = lineChars + queue.size() - 1;
            if (widthWithSpaces > maxWidth) {
                queue.removeLast();
                lineChars -= w.length();
                result.add(justifyLine(queue, maxWidth, false));
                queue.clear();
                lineChars = 0;
            } else {
                idx++;
            }
        }

        //마지막 줄 처리
        if (!queue.isEmpty()) {
            result.add(justifyLine(queue, maxWidth, true));
        }

        return result;
    }

    private String justifyLine(Deque<String> queue, int maxWidth, boolean isLastLine) {
        int wordCount = queue.size();
        int totalLetters = queue.stream().mapToInt(String::length).sum();
        StringBuilder sb = new StringBuilder();

        // Left-justify
        if (isLastLine || wordCount == 1) {
            while (!queue.isEmpty()) {
                sb.append(queue.pollFirst());
                if (!queue.isEmpty()) sb.append(' ');
            }
            
            while (sb.length() < maxWidth) {
                sb.append(' ');
            }

        // Full-justify
        } else {
            int totalSpaces   = maxWidth - totalLetters;  
            int slots         = wordCount - 1;            
            int spacePerSlot  = totalSpaces / slots;     
            int extra         = totalSpaces % slots;   

            while (queue.size() > 1) {
                sb.append(queue.pollFirst());
                int count = spacePerSlot + (extra > 0 ? 1 : 0);
                for (int i = 0; i < count; i++) {
                    sb.append(' ');
                }
                if (extra > 0) {
                    extra--;
                }
            }

            sb.append(queue.pollFirst());
        }
        return sb.toString();
    }
}
