import java.util.LinkedList;

public class MyHashTable<K, V> {
    private LinkedList<Entry<K, V>>[] buckets;
    private int size;
    private int capacity = 16;

    static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    @SuppressWarnings("unchecked")
    public MyHashTable() {
        buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
        size = 0;
    }

    // Put method
    public void put(K key, V value) {
        if (key == null) return; // no null keys
        int index = getIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        // Check if key exists
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value; // update value
                return;
            }
        }

        bucket.add(new Entry<>(key, value));
        size++;
    }

    public V get(K key) {
        if (key == null) return null;
        int index = getIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    public int size() {
        return size;
    }

    private int getIndex(K key) {
        int hash = key.hashCode();
        if (hash < 0) hash = -hash; // make positive
        return hash % capacity;
    }


    public int[] getBucketSizes() {
        int[] sizes = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            sizes[i] = buckets[i].size();
        }
        return sizes;
    }
}