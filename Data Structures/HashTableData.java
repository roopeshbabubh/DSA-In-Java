import java.util.ArrayList;

public class HashTableData {

    Node[] hashData;
    int hashDataSize = 7;
    int size;

    class Node {
        String key;
        int value;
        Node next;

        Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    HashTableData() {
        this.hashData = new Node[this.hashDataSize];
    }

    public void printHash() {
        for (int i = 0; i < hashData.length; i++) {
            Node temp = hashData[i];
            System.out.println(i + ": ");
            while (temp != null) {
                System.out.println("\tkey: " + temp.key + ", value: " + temp.value);
                temp = temp.next;
            }
        }
    }

    public int getHash(String key) {
        int hash = 0;
        char[] charArray = key.toCharArray();
        for (char charValue : charArray) {
            int asciiValue = charValue;
            hash = (hash + asciiValue * 31) % hashDataSize;
        }
        return hash;
    }

    public void put(String key, int value) {
        int hash = getHash(key);
        Node newNode = new Node(key, value);
        Node temp = hashData[hash];
        if (temp == null) {
            hashData[hash] = newNode;
            this.size += 1;
            return;
        }
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        this.size += 1;
    }

    public boolean contains(String key) {
        int hash = getHash(key);
        if (hashData[hash] != null) {
            Node temp = hashData[hash];
            while (temp != null && temp.key != key) {
                temp = temp.next;
            }
            if (temp != null && temp.key == key) return true;
        }
        return false;
    }

    public ArrayList allKeys() {
        ArrayList allKeys = new ArrayList();
        for (int i = 0; i < hashData.length; i++) {
            Node temp = hashData[i];
            while (temp != null) {
                allKeys.add(temp.key);
                temp = temp.next;
            }
        }
        return allKeys;
    }

    public int getSize() {
        return size;
    }

    public String remove(String key) {
        int hash = getHash(key);
        Node prev = null;
        if (hashData[hash] != null) {
            Node temp = hashData[hash];
            while (temp != null && temp.key != key) {
                prev = temp;
                temp = temp.next;
            }
            if (temp != null && temp.key == key) {
                if (temp.next == null) {
                    hashData[hash] = null;
                    prev = temp;
                } else {
                    if (prev == null) {
                        hashData[hash] = temp.next;
                        prev = temp;
                        temp = null;
                    } else {
                        Node tempNode = temp.next;
                        temp = null;
                        prev.next = tempNode;
                        prev = temp;
                    }
                }
                this.size--;
            }
        }
        return "key: " + prev.key + ", value: " + prev.value + " is removed from hash";
    }

    public String getValue(String key) {
        int hash = getHash(key);
        if (hashData[hash] != null) {
            Node temp = hashData[hash];
            while (temp != null && temp.key != key) {
                temp = temp.next;
            }
            if (temp != null && temp.key == key) return "value: " + temp.value;
        }
        return null;
    }
}
