class Solution {
    public int findKthLargest(int[] nums, int k) {
        int[] sortedNums = Arrays.stream(nums).sorted().toArray();

        return sortedNums[nums.length - k];
    }
}