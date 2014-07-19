
package core.bst;

// TODO: Auto-generated Javadoc
/**
 * The Class BSTNode.
 *
 * @param <K> the key type
 * @param <V> the value type
 */
public class BSTNode<K extends Comparable<? super K>, V> {
    
    /** The key. */
    protected K key;
    
    /** The value. */
    protected V value;
    
    /** The left. */
    protected BSTNode<K, V> left;
    
    /** The right. */
    protected BSTNode<K, V> right;
    
    /** The parent. */
    protected BSTNode<K, V> parent;

    /**
     * Checks if is empty.
     *
     * @return true, if is empty
     */
    public boolean isEmpty() {
        return this.key == null;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        String resp = "NIL";
        if (!isEmpty()) {
            resp = key.toString();
        }
        return resp;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object obj) {
        boolean resp = false;
        if (obj instanceof BSTNode) {
            resp = this.key.equals(((BSTNode<K, V>) obj).key);
        }
        return resp;
    }

    /**
     * Gets the key.
     *
     * @return the key
     */
    public K getKey() {
        return key;
    }

    /**
     * Sets the key.
     *
     * @param key the new key
     */
    public void setKey(K key) {
        this.key = key;
    }

    /**
     * Gets the value.
     *
     * @return the value
     */
    public V getValue() {
        return value;
    }

    /**
     * Sets the value.
     *
     * @param value the new value
     */
    public void setValue(V value) {
        this.value = value;
    }

    /**
     * Gets the left.
     *
     * @return the left
     */
    public BSTNode<K, V> getLeft() {
        return left;
    }

    /**
     * Sets the left.
     *
     * @param left the left
     */
    public void setLeft(BSTNode<K, V> left) {
        this.left = left;
    }

    /**
     * Gets the right.
     *
     * @return the right
     */
    public BSTNode<K, V> getRight() {
        return right;
    }

    /**
     * Sets the right.
     *
     * @param right the right
     */
    public void setRight(BSTNode<K, V> right) {
        this.right = right;
    }

    /**
     * Gets the parent.
     *
     * @return the parent
     */
    public BSTNode<K, V> getParent() {
        return parent;
    }

    /**
     * Sets the parent.
     *
     * @param parent the parent
     */
    public void setParent(BSTNode<K, V> parent) {
        this.parent = parent;
    }

    /**
     * Checks if is leaf.
     *
     * @return true, if is leaf
     */
    public boolean isLeaf() {
        boolean resp = false;
        if (!this.isEmpty()) {
            resp = this.getLeft().isEmpty() && this.getRight().isEmpty();
        }
        return resp;
    }
}
