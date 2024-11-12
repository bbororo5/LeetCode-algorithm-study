class Solution {
    public int searchInsert(int[] nums, int target) {
        int currentIndex = 0;
        for (int e: nums) {
            if (e < target) {
                currentIndex++;
                continue;
            } else {
                return currentIndex;
            }
        }

        return currentIndex;
    }
}