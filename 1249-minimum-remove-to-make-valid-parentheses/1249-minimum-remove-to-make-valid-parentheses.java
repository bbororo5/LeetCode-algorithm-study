class Solution {
    public String minRemoveToMakeValid(String s) {
        ArrayList<Character> charList = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            charList.add(s.charAt(i));
        }

        Deque<Integer> stack = new ArrayDeque<>();
        ArrayList<Integer> removeList = new ArrayList<>();

        for(int i = 0; i < charList.size(); i++) {
            char c = charList.get(i);

            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    removeList.add(i);
                } else {
                    stack.pop();
                }
            }
        }
        
        for (int i : stack) {
            removeList.add(stack.pop());
        }

        Collections.sort(removeList, Collections.reverseOrder());

        for (int index : removeList) {
            charList.remove(index);
        }

        StringBuilder result = new StringBuilder();
        for (char c : charList) {
            result.append(c);
        }
    
        return result.toString();
    }
}