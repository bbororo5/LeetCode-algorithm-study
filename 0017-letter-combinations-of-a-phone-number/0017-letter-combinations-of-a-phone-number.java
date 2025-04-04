class Solution {
    private static final Map<Character, String> PHONE_MAP = Map.of(
        '2', "abc",
        '3', "def",
        '4', "ghi",
        '5', "jkl",
        '6', "mno",
        '7', "pqrs",
        '8', "tuv",
        '9', "wxyz"
    );

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) return result;

        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String digits, int index, StringBuilder path, List<String> result) {
        if (index == digits.length()) {
            result.add(path.toString());
            return;
        }

        char digit = digits.charAt(index);
        String possibleLetters = PHONE_MAP.get(digit);

        for (char letter : possibleLetters.toCharArray()) {
            path.append(letter);                         
            backtrack(digits, index + 1, path, result);   
            path.deleteCharAt(path.length() - 1);         
        }
    }
}