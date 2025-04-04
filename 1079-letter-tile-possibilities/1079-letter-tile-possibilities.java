class Solution {
    public int numTilePossibilities(String tiles) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tiles.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return backtrack(map);
    }

    private int backtrack(Map<Character, Integer> map) {
        int count = 0;

        for (char c : map.keySet()) {
            int freq = map.get(c);
            if (freq == 0) continue;

            map.put(c, freq - 1);

            count += 1;

            count += backtrack(map);

            map.put(c, freq);
        }

        return count;
    }
}