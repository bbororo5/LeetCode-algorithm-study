class Solution {
    public int findKthPositive(int[] arr, int k) {
        List<Integer> list1 = new ArrayList<>();
        for(int i = 0; i < 2001; i++) {
            list1.add(i);
        }

        Set<Integer> set = new HashSet<Integer>();
        List<Integer> list2 = Arrays.stream(arr).boxed().toList();

        set.addAll(list1);

        set.removeAll(list2);
        int[] arr2 = set.stream().sorted().mapToInt(Integer::intValue).toArray();

        return arr2[k];
    }
}