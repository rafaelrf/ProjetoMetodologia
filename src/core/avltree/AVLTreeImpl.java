
package core.avltree;

import core.bst.BSTImpl;
import core.bst.BSTNode;

// TODO: Auto-generated Javadoc
/**
 * The Class AVLTreeImpl.
 *
 * @param <K> the key type
 * @param <V> the value type
 */
public class AVLTreeImpl<K extends Comparable<? super K>, V> extends BSTImpl<K, V> implements
        AVLTree<K, V>, Estrutura {

    // AUXILIARY
    /**
     * Calculate balance.
     *
     * @param node the node
     * @return the int
     */
    protected int calculateBalance(BSTNode<K, V> node) {
        if (node != null && !node.isEmpty()) {
            return heightAux(node.getLeft()) - heightAux(node.getRight());
        }
        return 0;
    }

    // AUXILIARY
    /**
     * Rebalance up.
     *
     * @param node the node
     */
    protected void rebalanceUp(BSTNode<K, V> node) {
        BSTNode<K, V> parent = node.getParent();
        while (parent != null) {
            rebalance(parent);
            parent = parent.getParent();
        }
    }

    /**
     * Rebalance.
     *
     * @param node the node
     */
    protected void rebalance(BSTNode<K, V> node) {
        if (Math.abs(calculateBalance(node)) > 1) {
            int balance = this.calculateBalance(node);
            if (balance > 1) {
                if (calculateBalance(node.getLeft()) >= 0) {
                    rightRotation(node);
                } else {
                    leftRotation(node.getLeft());
                    rightRotation(node);
                }
            } else if (balance < -1) {
                if (calculateBalance(node.getRight()) <= 0) {
                    leftRotation(node);
                } else {
                    rightRotation(node.getRight());
                    leftRotation(node);
                }
            }
        }
    }

    /* (non-Javadoc)
     * @see core.bst.BSTImpl#insert(java.lang.Comparable, java.lang.Object)
     */
    @Override
    public void insert(K key, V value) {
        insertAux(root, key, value);
    }

    /**
     * Insert aux.
     *
     * @param node the node
     * @param key the key
     * @param value the value
     */
    protected void insertAux(BSTNode<K, V> node, K key, V value) {
        if (node.isEmpty()) {
            node.setKey(key);
            node.setValue(value);
            node.setLeft(new BSTNode<K, V>());
            node.setRight(new BSTNode<K, V>());
            node.getLeft().setParent(node);
            node.getRight().setParent(node);

        } else {
            if (key.compareTo(node.getKey()) < 0) {
                insertAux(node.getLeft(), key, value);
            } else if (key.compareTo(node.getKey()) > 0) {
                insertAux(node.getRight(), key, value);
            }
            rebalanceUp(node);
        }
    }

    // AUXILIARY
    /**
     * Left rotation.
     *
     * @param node the node
     */
    protected void leftRotation(BSTNode<K, V> node) {

        if (node != null && !node.isEmpty()) {
            BSTNode<K, V> pivot = new BSTNode<K, V>();

            pivot.setKey(node.getRight().getKey());
            pivot.setValue(node.getRight().getValue());
            pivot.setLeft(node.getRight().getLeft());
            pivot.getLeft().setParent(pivot);
            pivot.setRight(node.getRight().getRight());
            pivot.getRight().setParent(pivot);

            node.getRight().setKey(pivot.getLeft().getKey());
            node.getRight().setValue(pivot.getLeft().getValue());
            node.getRight().setLeft(pivot.getLeft().getLeft());
            node.getRight().setRight(pivot.getLeft().getRight());
            node.getRight().setParent(node);

            pivot.getLeft().setKey(node.getKey());
            pivot.getLeft().setValue(node.getValue());
            pivot.getLeft().setLeft(node.getLeft());
            pivot.getLeft().getLeft().setParent(pivot.getLeft());
            pivot.getLeft().setRight(node.getRight());
            pivot.getLeft().getRight().setParent(pivot.getLeft());
            pivot.getLeft().setParent(pivot);

            node.setKey(pivot.getKey());
            node.setValue(pivot.getValue());
            node.setLeft(pivot.getLeft());
            node.getLeft().setParent(node);
            node.setRight(pivot.getRight());
            node.getRight().setParent(node);
            node.setParent(node.getParent());

        }
    }

    // AUXILIARY
    /**
     * Right rotation.
     *
     * @param node the node
     */
    protected void rightRotation(BSTNode<K, V> node) {

        if (node != null && !node.isEmpty()) {
            BSTNode<K, V> pivot = new BSTNode<K, V>();

            pivot.setKey(node.getLeft().getKey());
            pivot.setValue(node.getLeft().getValue());
            pivot.setLeft(node.getLeft().getLeft());
            pivot.getLeft().setParent(pivot);
            pivot.setRight(node.getLeft().getRight());
            pivot.getRight().setParent(pivot);

            node.getLeft().setKey(pivot.getRight().getKey());
            node.getLeft().setValue(pivot.getRight().getValue());
            node.getLeft().setLeft(pivot.getRight().getLeft());
            node.getLeft().setRight(pivot.getRight().getRight());
            node.getLeft().setParent(node);

            pivot.getRight().setKey(node.getKey());
            pivot.getRight().setValue(node.getValue());
            pivot.getRight().setLeft(node.getLeft());
            pivot.getRight().getLeft().setParent(pivot.getRight());
            pivot.getRight().setRight(node.getRight());
            pivot.getRight().getRight().setParent(pivot.getRight());
            pivot.getRight().setParent(pivot);

            node.setKey(pivot.getKey());
            node.setValue(pivot.getValue());
            node.setLeft(pivot.getLeft());
            node.getLeft().setParent(node);
            node.setRight(pivot.getRight());
            node.getRight().setParent(node);
            node.setParent(node.getParent());

        }
    }

    /* (non-Javadoc)
     * @see core.bst.BSTImpl#insert(java.lang.String)
     */
    @SuppressWarnings("unchecked")
    @Override
    public void insert(String word) {

        this.insert((K) word, (V) word);
    }

    /* (non-Javadoc)
     * @see core.bst.BSTImpl#search(java.lang.String)
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean search(String word) {

        return search((K) word);
    }

}
