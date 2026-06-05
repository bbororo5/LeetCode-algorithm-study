class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length == 1) return false;

        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<Integer>());
            }
            map.get(nums[i]).add(i);
                
        }

        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> value = entry.getValue();
            for(int i = 1; i < value.size(); i++) {
                if(Math.abs(value.get(i - 1) - value.get(i)) <= k) return true;
            }
        }
    
        return false;
    }
}