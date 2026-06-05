class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();

        for(String str : cpdomains) {
            String[] spl = str.split(" ");
            int number = Integer.parseInt(spl[0]);
            String domain = spl[1];

            while(true) {
                map.put(domain, map.getOrDefault(domain, 0) + number);

                if(domain.indexOf(".") == -1) {
                    break;
                }
                
                domain = domain.substring(domain.indexOf(".") + 1);
            }
        }

        List<String> result = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            result.add(String.valueOf(entry.getValue()) + " " + entry.getKey());
        }

        return result;
    }
}