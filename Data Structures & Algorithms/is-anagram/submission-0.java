class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] marker = new int[26];
        for (char c : s.toCharArray()) {
            ++marker[c - 'a'];
        }
        for (char c : t.toCharArray()) {
            --marker[c - 'a'];
        }
        for (int mark : marker) {
            if (mark != 0) return false;
        }
        return true;
    }
}
