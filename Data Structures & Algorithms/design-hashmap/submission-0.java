class MyHashMap {
    private class Entry {
        int key;
        int value;
        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    List<Entry> list;

    public MyHashMap() {
        list = new ArrayList<>();
    }
    
    public void put(int key, int value) {
        Entry existing = null;
        for (Entry entry : list) {
            if (entry.key == key) {
                existing = entry;
                break;
            }
        }
        if (existing != null) {
            existing.value = value;
        } else {
            list.add(new Entry(key, value));
        }
    }
    
    public int get(int key) {
        for (Entry entry : list) {
            if (entry.key == key) {
                return entry.value;
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i).key == key) {
                list.remove(i);
                break;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */