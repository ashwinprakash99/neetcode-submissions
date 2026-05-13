class MyHashMap {
    private class EntryNode {
        int key;
        int value;
        EntryNode next;
        EntryNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    EntryNode[] list;

    public MyHashMap() {
        list = new EntryNode[10000];
    }
    
    public void put(int key, int value) {
        int hash = key % list.length;
        EntryNode node = list[hash];
        if (node == null) {
            list[hash] = new EntryNode(key, value);
        } else {
            while (node.next != null) {
                if (node.key == key) {
                    node.value = value;
                    return;
                }
                node = node.next;
            }
            if (node.key == key) {
                node.value = value;
                return;
            }
            node.next = new EntryNode(key, value);
        }
    }
    
    public int get(int key) {
        int hash = key % list.length;
        EntryNode node = list[hash];
        while (node != null) {
            if (node.key == key) {
                return node.value;
            }
            node = node.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        int hash = key % list.length;
        EntryNode node = list[hash];
        if (node != null) {
            if (node.key == key) {
                list[hash] = node.next;
            } else {
                EntryNode temp = node;
                while (node != null) {
                    if (node.key == key) {
                        temp.next = node.next;
                        break;
                    }
                    temp = node;
                    node = node.next;
                }
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