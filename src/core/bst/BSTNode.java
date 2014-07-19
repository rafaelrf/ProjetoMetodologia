
package core.bst;

public class BSTNode<K extends Comparable<? super K>, V> {
    protected K key;
    protected V value;
    protected BSTNode<K, V> left;
    protected BSTNode<K, V> right;
    protected BSTNode<K, V> parent;

    public boolean isEmpty() {
        return this.key == null;
    }

    @Override
    public String toString() {
        String resp = "NIL";
        if (!isEmpty()) {
            resp = key.toString();
        }
        return resp;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object obj) {
        boolean resp = false;
        if (obj instanceof BSTNode) {
            resp = this.key.equals(((BSTNode<K, V>) obj).key);
        }
        return resp;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public BSTNode<K, V> getLeft() {
        return left;
    }

    public void setLeft(BSTNode<K, V> left) {
        this.left = left;
    }

    public BSTNode<K, V> getRight() {
        return right;
    }

    public void setRight(BSTNode<K, V> right) {
        this.right = right;
    }

    public BSTNode<K, V> getParent() {
        return parent;
    }

    public void setParent(BSTNode<K, V> parent) {
        this.parent = parent;
    }

    public boolean isLeaf() {
        boolean resp = false;
        if (!this.isEmpty()) {
            resp = this.getLeft().isEmpty() && this.getRight().isEmpty();
        }
        return resp;
    }
}
