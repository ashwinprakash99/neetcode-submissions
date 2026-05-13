class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        encoded.append(strs.stream().map(String::length).map(Object::toString).collect(Collectors.joining(",")));
        encoded.append("#");
        encoded.append(strs.stream().collect(Collectors.joining("")));
        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        if (str.charAt(0) == '#') return result;
        int i = 0;
        while (str.charAt(i) != '#') {
            ++i;
        }
        int[] sizes = Arrays.stream(str.substring(0, i).split(",")).mapToInt(Integer::valueOf).toArray();
        System.out.println(Arrays.toString(sizes));
        ++i;
        for (int size : sizes) {
            result.add(str.substring(i, i+size));
            i += size;
        }
        return result;
    }
}
