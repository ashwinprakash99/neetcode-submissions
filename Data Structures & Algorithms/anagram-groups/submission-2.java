class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int[] marker = new int[26];
            for (char c : s.toCharArray()) {
                ++marker[c - 'a'];
            }
            String key = Arrays.stream(marker).mapToObj(String::valueOf).collect(Collectors.joining("-"));
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
