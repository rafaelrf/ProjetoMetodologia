
package core.bst;

// TODO: Auto-generated Javadoc
/**
 * The Interface BST.
 *
 * @param <K> the key type
 * @param <V> the value type
 */
public interface BST<K extends Comparable<? super K>, V> {
    
    /**
     * Returns the root of the tree.
     *
     * @return the root
     */
    public BSTNode<K, V> getRoot();

    /**
     * Say if a BST is empty (NIL).
     *
     * @return true, if is empty
     */
    public boolean isEmpty();

    /**
     * The height of a BST. An empty BST has height -1 (there is no root
     * element).
     *
     * @return the int
     */
    public int height();

    /**
     * Searches a key in a BST. The search starts at the root node.If the key
     * does not exist the methods returns null.
     *
     * @param key the key
     * @return true, if successful
     */
    public boolean search(K key);

    /**
     * Inserts a key in a a BST.
     *
     * @param key the key
     * @param value the value
     */
    public void insert(K key, V value);

    /**
     * Returns the node containing the greatest key in a BST rooted by the given
     * node. If the node has no right child then it contains the largest key. If
     * the node is empty the method returns null.
     *
     * @param node the node
     * @return the BST node
     */
    public BSTNode<K, V> maximum(BSTNode<K, V> node);

    /**
     * Returns the node containing the lowest key in a BST rooted by the given
     * node. If the node has no left child then it contains the lowest key. If
     * the node is empty the method returns null.
     *
     * @param node the node
     * @return the BST node
     */
    public BSTNode<K, V> minimum(BSTNode<K, V> node);

    /**
     * Returns the successor of a node in a BST or null if it does not exist.
     *
     * @param node the node
     * @return the BST node
     */
    public BSTNode<K, V> sucessor(BSTNode<K, V> node);

    /**
     * Returns the predecessor of a node in a BST or null if it does not exist.
     *
     * @param node the node
     * @return the BST node
     */
    public BSTNode<K, V> predecessor(BSTNode<K, V> node);

    /**
     * Removes a node from a BST.
     *
     * @param key the key
     */
    public void remove(K key);

    /**
     * Returns an array of keys filled according to the pre-order traversing in
     * a BST.
     *
     * @return the k[]
     */
    public K[] preOrder();

    /**
     * Returns an array of keys filled according to the symmetric order
     * traversing in a BST.
     *
     * @return the k[]
     */
    public K[] order();

    /**
     * Returns an array of keys filled according to the port-order traversing in
     * a BST.
     *
     * @return the k[]
     */
    public K[] postOrder();

    /**
     * Returns the number of nodes (not NIL) in a BST.
     *
     * @return the int
     */
    public int size();
}
