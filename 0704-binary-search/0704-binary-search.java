import java.util.*;

class Solution {
    public int search(int[] nums, int target) {
        return IntStream.range(0, nums.length)
        .filter(i -> nums[i] == target)
        .findFirst()
        .orElse(-1);
    }
}