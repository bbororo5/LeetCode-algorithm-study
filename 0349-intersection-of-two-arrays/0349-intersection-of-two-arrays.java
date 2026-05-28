class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int size = Math.min(nums1.length, nums2.length);
        List<Integer> intersectList = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for(int n : nums1) {
            set.add(n);
        }

        for(int n : nums2) {
            if(set.contains(n)) {
                intersectList.add(n);
                set.remove(n);
            }
        }

        int[] result = new int[intersectList.size()];
        for (int i = 0; i < intersectList.size(); i++) {
            result[i] = intersectList.get(i);
        }

        return result;
    }
}