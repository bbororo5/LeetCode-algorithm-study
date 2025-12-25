class Solution {
    public String defangIPaddr(String address) {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < address.length(); i++) {
            char c = address.charAt(i);
            if(c == '.') {
                str.append("[.]");
            } else {
                str.append(c);
            }
        }

        return str.toString();
    }
}