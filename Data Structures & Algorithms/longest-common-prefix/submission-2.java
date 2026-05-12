class Solution {
    public String longestCommonPrefix(String[] strs) {
        String result = "";
        int pos = 0;
        while (true) {
            boolean stop = false;
            if (strs[0].length() == pos) {
                break;
            }
            char current = strs[0].charAt(pos);
            for (int i = 1; i < strs.length; ++i) {
                if (strs[i].length() == pos || current != strs[i].charAt(pos)) {
                    stop = true;
                    break;
                }
            }
            if (stop) break;
            result += current;
            ++pos;
        }
        return result;
    }
}