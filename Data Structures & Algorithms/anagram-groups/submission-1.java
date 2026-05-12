class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int[] marker = new int[26];
            for (char c : s.toCharArray()) {
                ++marker[c - 'a'];
            }
            String key = Arrays.stream(marker).mapToObj(String::valueOf).collect(Collectors.joining("-"));
            if (map.containsKey(key)) {
                map.get(key).add(s);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(s);
                map.put(key, newList);
            }
        }
        List<List<String>> result = new ArrayList();
        for (List<String> value : map.values()) {
            result.add(value);
        }
        return result;
    }
}
