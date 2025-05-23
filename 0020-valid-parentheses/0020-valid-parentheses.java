class Solution {
    public boolean isValid(String s) {
        char[] parnethesesArrray = s.toCharArray();
        if (parnethesesArrray.length % 2 != 0) {
            return false;
        }

        Deque<Character> stack = new ArrayDeque<>();

        for (char c : parnethesesArrray) {
            switch (c) {
                case '(':
                    stack.push(')');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case ')':
                    if (!stack.isEmpty() && stack.peek() == ')') {
                        stack.pop();
                        break;
                    }
                    return false;
                case '}':
                    if (!stack.isEmpty() && stack.peek() == '}') {
                        stack.pop();
                        break;
                    }
                    return false;
                case ']':
                    if (!stack.isEmpty() && stack.peek() == ']') {
                        stack.pop();
                        break;
                    }
                    return false;
            }
        }

        return stack.isEmpty();
    }
}