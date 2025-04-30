class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int currentNumber = 0;
        char operation = '+';

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (Character.isDigit(currentChar)) {
                currentNumber = currentNumber * 10 + (currentChar - '0');
            }

            if(!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == s.length() - 1) {
                switch(operation) {
                    case '+' -> stack.push(currentNumber);
                    case '-' -> stack.push(-currentNumber);
                    case '*' -> stack.push(stack.pop() * currentNumber);
                    case '/' -> stack.push(stack.pop() / currentNumber);
                }
                operation = currentChar;
                currentNumber = 0;
            }
        }

        int result = 0;
        while(!stack.isEmpty()) {
            result += stack.pop();
        }
        
        return result;
    }
}