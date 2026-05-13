class MyHashMap {
    private class Entry {
        int key;
        int value;
        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    Entry[] list;

    public MyHashMap() {
        list = new Entry[1000001];
    }
    
    public void put(int key, int value) {
        Entry entry = list[key];
        if (entry == null) {
            list[key] = new Entry(key, value);
        } else {
            list[key].value = value;
        }
    }
    
    public int get(int key) {
        Entry entry = list[key];
        return entry != null ? entry.value : -1;
    }
    
    public void remove(int key) {
        list[key] = null;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */