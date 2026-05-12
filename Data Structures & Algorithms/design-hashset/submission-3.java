class MyHashSet {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    ListNode[] set;

    public MyHashSet() {
        set = new ListNode[10000];
    }
    
    public void add(int key) {
        int hash = key % set.length;
        ListNode node = set[hash];

        ListNode newNode = new ListNode(key);

        if (node == null) {
            set[hash] = newNode;
        } else {
            while (node.next != null) {
                if (node.val == key) return;
                node = node.next;
            }
            if (node.val == key) return;
            node.next = newNode;
        }
    }
    
    public void remove(int key) {
        int hash = key % set.length;
        ListNode node = set[hash];

        ListNode temp = node;
        if (node != null && node.val == key) {
            set[hash] = node.next;
        }

        while (node != null) {
            if (node.val == key) {
                temp.next = node.next;
            }
            temp = node;
            node = node.next;
        }
    }
    
    public boolean contains(int key) {
        int hash = key % set.length;
        ListNode node = set[hash];

        if (node == null) {
            return false;
        }

        while (node != null) {
            if (node.val == key) {
                return true;
            }
            node = node.next;
        }

        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */