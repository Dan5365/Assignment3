import java.util.Iterator;
import java.util.Stack;

public class MyBSTEnhanced<K extends Comparable<K>, V> implements Iterable<MyBSTEnhanced.Entry<K, V>> {
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

    public static class Entry<K, V> {
        private K key;
        private V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }


    public MyBSTEnhanced() {
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
                current.value = value;
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

    public int size() {
        return size;
    }

    @Override
    public Iterator<Entry<K, V>> iterator() {
        return new InOrderIterator();
    }

    private class InOrderIterator implements Iterator<Entry<K, V>> {
        private Stack<Node> stack = new Stack<>();
        private Node current;

        InOrderIterator() {
            current = root;
            pushLeft();
        }

        private void pushLeft() {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public Entry<K, V> next() {
            Node node = stack.pop();
            Entry<K, V> entry = new Entry<>(node.key, node.value);
            current = node.right;
            pushLeft();
            return entry;
        }
    }

    public static void main(String[] args) {
        MyBSTEnhanced<Integer, String> tree = new MyBSTEnhanced<>();
        tree.put(5, "Five");
        tree.put(3, "Three");
        tree.put(7, "Seven");
        tree.put(2, "Two");
        tree.put(4, "Four");

        System.out.println("Tree size: " + tree.size());
        for (Entry<Integer, String> elem : tree) {
            System.out.println("key is " + elem.getKey() + " and value is " + elem.getValue());
        }
    }
}