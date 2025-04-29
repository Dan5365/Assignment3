public class MyBST<K extends Comparable<K>, V> {
    private Node root;
    private int size;

    private class Node {
        K key;
        V value;
        Node left, right;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyBST() {
        root = null;
        size = 0;
    }

    public void put(K key, V value) {
        if (key == null) return;

        if (root == null) {
            root = new Node(key, value);
            size++;
            return;
        }

        Node current = root;
        while (true) {
            int cmp = key.compareTo(current.key);
            if (cmp < 0) {
                if (current.left == null) {
                    current.left = new Node(key, value);
                    size++;
                    break;
                }
                current = current.left;
            } else if (cmp > 0) {
                if (current.right == null) {
                    current.right = new Node(key, value);
                    size++;
                    break;
                }
                current = current.right;
            } else {
                current.value = value; // update value
                break;
            }
        }
    }

    public V get(K key) {
        if (key == null) return null;

        Node current = root;
        while (current != null) {
            int cmp = key.compareTo(current.key);
            if (cmp < 0) {
                current = current.left;
            } else if (cmp > 0) {
                current = current.right;
            } else {
                return current.value;
            }
        }
        return null;
    }
}