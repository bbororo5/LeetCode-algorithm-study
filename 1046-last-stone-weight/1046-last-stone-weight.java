class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 1) {
            return stones[0];
        }

        stones = Arrays.stream(stones)
               .boxed()
               .sorted(Collections.reverseOrder())
               .mapToInt(Integer::intValue)
               .toArray();

        while (stones[1] != 0) {
            int smashResult = stones[0] - stones[1];
            if (smashResult == 0) {
                stones[0] = 0;
                stones[1] = 0;
            } else {
                stones[0] = smashResult;
                stones[1] = 0;
            }

            stones = Arrays.stream(stones)
               .boxed()
               .sorted(Collections.reverseOrder())
               .mapToInt(Integer::intValue)
               .toArray();
        }

        return stones[0];
    }
}